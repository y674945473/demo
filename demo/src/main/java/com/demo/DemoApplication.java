package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class DemoApplication 
{
	private static Logger Logger = LoggerFactory.getLogger(DemoApplication.class);
    public static void main( String[] args )
    {
        SpringApplication.run(DemoApplication.class, args);
        Logger.info(">>>>>>>>demo服务启动成功<<<<<<<<<<");
    }
}
