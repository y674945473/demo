package com.demo.singleton;

public class Singleton3 {

	/***
	 * 单例模式：双重锁模式
	 * 线程安全，延迟初始化。这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
	 * 由于singleton=new Singleton()对象的创建在JVM中可能会进行重排序，在多线程访问下存在风险，使用volatile修饰signleton实例变量有效
	 * 双重检查模式，进行了两次的判断，第一次是为了避免不要的实例，第二次是为了进行同步，避免多线程问题
	 */
	private volatile static Singleton3 Singleton3;  
    private Singleton3 (){}  
    public static Singleton3 getSingleton3() {  
	    if (Singleton3 == null) {  
	        synchronized (Singleton3.class) {  
	        	/**
                 * 由于编译器的优化、JVM的优化、操作系统处理器的优化，可能会导致指令重排（happen-before规则下的指令重排，执行结果不变，指令顺序优化排列）
                 * new Singleton3()这条语句大致会有这三个步骤：
                 * 1.在堆中开辟对象所需空间，分配内存地址
                 * 2.根据类加载的初始化顺序进行初始化
                 * 3.将内存地址返回给栈中的引用变量
                 * 
                 * 但是由于指令重排的出现，这三条指令执行顺序会被打乱，可能导致3的顺序和2调换
                 * 👇
                 */
		        if (Singleton3 == null) {  
		            Singleton3 = new Singleton3();  
		        }  
	        }  
	    }  
	    return Singleton3;  
    }    
}
