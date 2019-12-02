package com.demo.web;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.RedisService;
@RestController
public class RedisController {

	private Logger logger = LoggerFactory.getLogger(RedisController.class);
		@Autowired
	  private RedisService redisService;
	    
	   @RequestMapping("/setString")
	   public String setString(@RequestParam(value= "key") String key, @RequestParam(value= "value") String value){
		   logger.info("key:"+key+",value:"+value);
		   String[] split = value.split(",");
	       redisService.set(key, split, 500l); //超时时间50s   l表示long型
	       return "成功";
	   }
	   
	   @RequestMapping("get")
	   public String get(@RequestParam(value= "key")String key){
		   logger.info("key:"+key);
	       return redisService.getString(key);
	   }
}
