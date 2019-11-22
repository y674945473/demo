package com.demo.web;

import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;

import com.demo.concumer.Consumer;
import com.demo.producer.Producer;

public class test {

	char[] c = new char[64];

//    public static void main(String[] args) {
//    	test test = new test();
//        System.out.println(test.check(2));
//        test.add(2);
//        System.out.println(test.check(2));
//        
//    }
	
//	public static void main(String[] args) {
//        //算的时候用补码算，才是正确的结果
//        //1向右移两位
//        System.out.println("1>>2="+(1>>2));
//        System.out.println("-1>>2="+(-1>>2));
//        
//        System.out.println("1<<1="+(1<<1));//移动移位*2
//        System.out.println("1<<2="+(1<<2));//移动两位*4
//        System.out.println("2<<2="+(2<<2));//移动两位*4        
//        System.out.println("-1<<2="+(-1<<2));
//        
//        System.out.println("3>>>1="+(3>>>1));
//        System.out.println("3>>>2="+(3>>>2));
//    }
	
//	public static void main(String[] args) {
//        //算的时候用补码算，才是正确的结果
//        System.out.println("~2=" + (~2));
//        System.out.println("2&3=" + (2&3));
//        System.out.println("2|3=" + (2|3));
//        System.out.println("~-5=" + (~-5));
//        System.out.println("-3^3="+(-3^3));
//    }
	
//	public static void main(String[] args) throws InterruptedException {
//        // 声明一个容量为10的缓存队列 LinkedBlockingQueue基于链表式的队列
//        BlockingQueue<String> queue = new LinkedBlockingQueue<String>(10);
// 
//        //new了三个生产者和一个消费者
//        Producer producer1 = new Producer(queue);
//        Producer producer2 = new Producer(queue);
//        Producer producer3 = new Producer(queue);
//        Consumer consumer = new Consumer(queue);
// 
//        // 借助Executors 线程池
//        ExecutorService service = Executors.newCachedThreadPool();
//        // 启动线程
//        service.execute(producer1);
//        service.execute(producer2);
//        service.execute(producer3);
//        service.execute(consumer);
// 
//        // 执行10s
//        Thread.sleep(10 * 1000);
//        producer1.stop();
//        producer2.stop();
//        producer3.stop();
// 
//        Thread.sleep(2000);
//        // 退出Executor
//        service.shutdown();
//    }

	public static void main(String[] args) {
		//创建topic
        Properties props = new Properties();
        props.put("bootstrap.servers", "你Kafka服务器ＩＰ:9092");
        AdminClient adminClient = AdminClient.create(props);
        ArrayList<NewTopic> topics = new ArrayList<NewTopic>();
        NewTopic newTopic = new NewTopic("topic-test", 1, (short) 1);
        topics.add(newTopic);
        CreateTopicsResult result = adminClient.createTopics(topics);
        try {
            result.all().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
	}
	
    public void add(int num) {
    	System.out.println("----:"+(num >> 3));
        c[num >> 3] |= (1 << (num & 0x07));
    }

    public boolean check(int num) {
    	System.out.println(1 << (num & 0x07));
    	System.out.println("------1");
    	System.out.println(num & 0x07);
        return (c[num >> 3] & (1 << (num & 0x07))) != 0x00;
    }
}
