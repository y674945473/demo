package com.hotel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/***
 * 
 * @author yuhongxu
 *	2019-11-26
 */
@SpringBootApplication
public class HotelApplication 
{
	private static Logger logger = LoggerFactory.getLogger(HotelApplication.class);
    public static void main( String[] args )
    {
        SpringApplication.run(HotelApplication.class, args);
        logger.info(">>>>>>>>>>hotel服务启动成功<<<<<<<<<<<<");
    }
}
