package com.ikentop.biz.provider.advisor;

import com.ikentop.framework.core.exception.ArgumentsValidatingException;
import com.ikentop.framework.core.pojo.ValidationErrorInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.Errors;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tac
 * @since 21/09/2017
 */
@Aspect
@Component
public class ValidationAdvisor {
    @Pointcut("execution(* com.ikentop.biz.provider.controller.*.*(..))")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object aroundPerform(ProceedingJoinPoint point) throws Throwable {
        List<ValidationErrorInfo> infos = new ArrayList<>();
        for (Object arg : point.getArgs()){
            if(arg instanceof Errors){
                infos.addAll(extractAll((Errors)arg));
            }
        }
        if(!CollectionUtils.isEmpty(infos)){
            throw new ArgumentsValidatingException(infos);
        }
        return point.proceed();
    }

    private List<ValidationErrorInfo> extractAll(Errors arg) {
        ArrayList<ValidationErrorInfo> infos = new ArrayList<>();
        if(arg.hasFieldErrors()){
            arg.getFieldErrors().forEach( fe -> {
                infos.add(new ValidationErrorInfo(fe.getField(), fe.getRejectedValue(), fe.getDefaultMessage()));
            });
        }
        return infos;
    }

}
