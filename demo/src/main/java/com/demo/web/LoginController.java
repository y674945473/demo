package com.demo.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.LoginService;

@RestController
@RequestMapping(value="/login")
public class LoginController {

	private static Logger Logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/login")
	public String login(@RequestParam("code") String code){
		Logger.info("登录验证code："+code);
		String login = loginService.login(code);
		Logger.info("权限："+login);
		return login;
	}
	
	@RequestMapping(value="/registered")
	public String getUser(@RequestParam("code") String code,@RequestParam("invitationCode") String invitationCode){
		Logger.info("注册验证code："+code);
		String user = loginService.getUser(code,invitationCode);
		return user;
	}
	
	
}
