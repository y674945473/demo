package com.demo.web;

import java.util.concurrent.atomic.AtomicInteger;

import com.demo.producer.TestRunable;

public class Executor {

	public static void main(String[] args) {
//		ThreadPoolExecutor tpe = new ThreadPoolExecutor(
//				2,//核心线程数线程数定义了最小可以同时运行的线程数量。
//				3,//当队列中存放的任务达到队列容量的时候，当前可以同时运行的线程数量变为最大线程数。
//				3,//当线程池中的线程数量大于 corePoolSize 的时候，如果这时没有新的任务提交，核心线程外的线程不会立即销毁，而是会等待，直到等待的时间超过了 keepAliveTime才会被回收销毁；
//				TimeUnit.DAYS,//keepAliveTime 参数的时间单位。
//				new ArrayBlockingQueue<>(2)//当新任务来的时候会先判断当前运行的线程数量是否达到核心线程数，如果达到的话，信任就会被存放在队列中。
//				,new ThreadPoolExecutor.CallerRunsPolicy());
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(new TestRunable());
			t.start();
		}
	}

}
