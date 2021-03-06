package com.chengxiaoxiao.seckillshop.controller;

import com.chengxiaoxiao.seckillshop.result.Result;
import com.chengxiaoxiao.seckillshop.service.MiaoshaUserService;
import com.chengxiaoxiao.seckillshop.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {

    private static Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    MiaoshaUserService miaoshaService;

    @RequestMapping("/to_login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/do_login")
    @ResponseBody
    public Result<Boolean> doLogin(HttpServletResponse response, @Valid UserVo userVo) {
        boolean result = miaoshaService.login(response, userVo);

        return Result.success(true);
    }
}
