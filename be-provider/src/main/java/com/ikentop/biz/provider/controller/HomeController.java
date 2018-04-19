package com.ikentop.biz.provider.controller;

import com.ikentop.biz.provider.exception.ImageCodeVerifyFailedException;
import com.ikentop.biz.provider.exception.UserAccountOrPasswordException;
import com.ikentop.biz.provider.model.OperatorLoginResultDto;
import com.ikentop.biz.provider.model.dto.OperatorLoginExtDto;
import com.ikentop.biz.provider.service.OperatorService;

import com.ikentop.biz.provider.util.HelpUtils;
import com.ikentop.framework.core.pojo.RestfulApiResponse;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * 首页和登录基控制器
 * @author zhangqing
 */
@Controller
public class HomeController {
    @Autowired
    protected OperatorService operatorService;


    private Logger logger = LoggerFactory.getLogger(HomeController.class);
    /**
     * 根目录
     * @return
     */
    @RequestMapping("/")
    public String root() {
        return "redirect:/index";
    }

    /**
     * 首页
     * @return
     */
    @ApiOperation("首页")
    @RequestMapping("index")
    public String index(ModelMap modelMap) throws Exception{

        return "index";
    }
    /**
     * 登录页面
     * @return
     */
    @ApiOperation("登录页面")
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(String message, ModelMap modelMap) {
        if(HelpUtils.isNotEmpty(message)){
            modelMap.addAttribute("message",message);
        }
        return "login";
    }
    /**
     * 登录动作
     * @param user
     * @return
     */

    /*@ApiOperation("用户登录")
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(OperatorLoginExtDto dto, HttpServletRequest req, RedirectAttributes attr, Errors errors) {
        *//*if (!verifyImageCode(dto.getImageCode(), req))
            throw new ImageCodeVerifyFailedException();*//*
        if(HelpUtils.isEmpty(dto.getUsername()) || HelpUtils.isEmpty(dto.getPassword())){
            attr.addAttribute("message","用户名或密码不能为空");
            return "redirect:/login";
        }
        String userName = dto.getUsername();
        OperatorLoginResultDto log=null;
        try {
         log=operatorService.login(dto);
        }catch(UserAccountOrPasswordException uae){
            logger.info("对用户[" + userName + "]进行登录验证..验证未通过,未知账户/密码");
            attr.addAttribute("message", "用户名不存在或密码错误");
        }
        if(log!=null){
            return "";
        }else{
            return "redirect:/login";
        }
    }*/


}
