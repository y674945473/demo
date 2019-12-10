package com.demo.producer;

import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class TestRunable implements Runnable{

//	private AtomicInteger count = new AtomicInteger(10);
//    //使用AtomicInteger之后，不需要对该方法加锁，也可以实现线程安全。
//      public void increment() {
//                count.incrementAndGet();
//      }
//   
//     public int getCount() {
//              return count.get();
//      }
//	@Override
//	public void run() {
//		for (int i = 0; i < 10; i++) {
//			increment();
//			System.out.println(count.get());
//		}
//		
//	}
	
	// SimpleDateFormat 不是线程安全的，所以每个线程都要有自己独立的副本
    private static final ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd HHmm"));

    public static void main(String[] args) throws InterruptedException {
    	TestRunable obj = new TestRunable();
        for(int i=0 ; i<10; i++){
            Thread t = new Thread(obj, ""+i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }
    }

    @Override
    public void run() {
        System.out.println("Thread Name= "+Thread.currentThread().getName()+" default Formatter = "+formatter.get().toPattern());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //formatter pattern is changed here by thread, but it won't reflect to other threads
        formatter.set(new SimpleDateFormat());

        System.out.println("Thread Name= "+Thread.currentThread().getName()+" formatter = "+formatter.get().toPattern());
    }


}
