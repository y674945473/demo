package com.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class KafkaApplication 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(KafkaApplication.class, args);
        System.out.println( "Hello World!" );
    }
}
