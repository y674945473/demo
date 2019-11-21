package com.demo.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.demo.entity.test;;
@Controller
@RequestMapping(value = "/config")
public class testweb {

	 @Autowired
	    private test test;
	 @Value("${spring.application.name}")
	 private String port;
	 
	    @RequestMapping("/test")
	    @ResponseBody
	    public Map<String, Object> test(){

	        Map<String, Object> map = new HashMap<>();
	        map.put("url", test.getUrl());
	        map.put("userName", test.getUsername());
	        map.put("password", test.getPassword());
	        map.put("className", test.getDriverClassName());
	        map.put("test", port);
	        map.put("test1", test.getType());
	        
	        return map;
	    }
}
