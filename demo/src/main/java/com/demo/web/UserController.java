package com.demo.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.AuditVO;
import com.demo.service.UserService;

@RestController
@RequestMapping(value="/user")
public class UserController {

	private static Logger Logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/score")
	public String getScore(@RequestParam("date") String date,@RequestParam("c") int c,@RequestParam("id") String id){
		String score = userService.getScore(date, c, id);
		return score;
	}
	
	@RequestMapping(value="/user")
	public String getUser(@RequestParam("code") String code){
		Logger.info("code："+code);
		String score = userService.getUser(code);
		return score;
	}
	
	@RequestMapping(value="/userScore")
	public String getUserScore(@RequestParam("date")String date,@RequestParam("id")String id){
		String score = userService.getUserScore(date, id);
		return score;
	}
	
	@RequestMapping(value="/insert")
	public void insert(@RequestParam("auditVo") AuditVO auditVo){
		userService.insert(auditVo);
	}
	
	@RequestMapping(value="/self")
	public void updateSelf(@RequestParam("auditVo") AuditVO auditVo){
		 userService.updateSelf(auditVo);
	}
	
	@RequestMapping(value="/audit")
	public void updateAudit(@RequestParam("auditVo") AuditVO auditVo){
		userService.updateAudit(auditVo);
	}
}
