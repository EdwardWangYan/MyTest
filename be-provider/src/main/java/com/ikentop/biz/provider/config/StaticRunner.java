package com.ikentop.biz.provider.config;

import com.ikentop.biz.provider.exception.AccountUnauthenticatedException;
import com.ikentop.biz.provider.exception.OperatorHaveNoPermissionException;
import com.ikentop.biz.provider.exception.UserAccountOrPasswordException;
import com.ikentop.framework.webapp.exceptionhandler.CustomExceptionHandler;
import com.ikentop.framework.webapp.exceptionhandler.converter.GenericExceptionConverterSupport;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author tac
 * @since 23/10/2017
 */
@Component
public class StaticRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        CustomExceptionHandler.addExceptionConverter(new GenericExceptionConverterSupport<UnauthenticatedException>() {
            @Override
            protected Exception doConvert(UnauthenticatedException e) {
                return new AccountUnauthenticatedException();
            }

            @Override
            protected boolean canConvert(Exception from) {
                return from instanceof UnauthenticatedException;
            }
        });
        CustomExceptionHandler.addExceptionConverter(new GenericExceptionConverterSupport<AuthenticationException>() {
            @Override
            protected Exception doConvert(AuthenticationException e) {
                if (e.getCause() != null) {
                    return (Exception) e.getCause();
                }
                return new UserAccountOrPasswordException();
            }

            @Override
            protected boolean canConvert(Exception from) {
                return from instanceof AuthenticationException;
            }
        });

        CustomExceptionHandler.addExceptionConverter(new GenericExceptionConverterSupport<AuthorizationException>() {
            @Override
            protected Exception doConvert(AuthorizationException e) {
                return new OperatorHaveNoPermissionException();
            }

            @Override
            protected boolean canConvert(Exception from) {
                return from instanceof AuthorizationException;
            }
        });
    }
}
