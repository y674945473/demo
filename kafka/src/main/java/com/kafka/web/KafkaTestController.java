package com.kafka.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kafka.producer.KfkaProducer;

@Controller
public class KafkaTestController {

	@Autowired
	private KfkaProducer producer;
	
	@RequestMapping("/testSendMsg")
	@ResponseBody
	public String testSendMsg(@RequestParam(value = "code" )String code){
		producer.send(code);
		return "success";
	}
	
}
