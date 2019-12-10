package com.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KfkaProducer {
	
	private static Logger logger = LoggerFactory.getLogger(KfkaProducer.class);
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	//发送消息方法
    public void send(String code) {
    	for(int i=0;i<5;i++){
            logger.info("发送消息 ----->>>>>  message = {}", i+"aaaaa");
            kafkaTemplate.send(code, i+"aaaaa");
    	}
    }

}
