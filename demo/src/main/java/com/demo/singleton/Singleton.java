package com.demo.singleton;

public class Singleton {

	/***
	 * 单例模式：懒汉模式
	 * 线程不安全，延迟初始化，严格意义上不是不是单例模式
	 * 类构造器私有
		持有自己类型的属性
		对外提供获取实例的静态方法
	 */
	private static Singleton instance;  
    private Singleton (){}  
  
    public static Singleton getInstance() {  
	    if (instance == null) {  
	        instance = new Singleton();  
	    }  
	    return instance;  
    }  
}
