package com.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.LoginDao;

@Service
public class LoginService {

	private static Logger Logger = LoggerFactory.getLogger(LoginService.class);
	
	@Autowired
	private LoginDao loginDao;
	
	public String login(String code){
		String login = loginDao.login(code);
		return login;
	}
	
	public String getUser(String code,String invitationCode){
		String user = loginDao.getUser(code,invitationCode);
		return user;
	}
}
