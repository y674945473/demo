package com.kafka.producer;

import java.util.UUID;

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
	
//	private Gson gson = new GsonBuilder().create();
	
	//发送消息方法
    public void send() {
    	for(int i=0;i<5;i++){
//    		Message message = new Message();
//            message.setId(System.currentTimeMillis());
//            message.setMsg(UUID.randomUUID().toString()+ "---" +i);
//            message.setSendTime(new Date());
            logger.info("发送消息 ----->>>>>  message = {}", "111111");
            kafkaTemplate.send("hello", "1111111111");
    	}
    }

}
