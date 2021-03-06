package com.wangjun.othersOfJava;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/*
 * 实现线程的三种方式：
 * 1. 继承Thread
 * 2. 实现Runnable接口
 * 3. 实现Callable接口
 * 区别：
 * 1. 第一种方式继承Thread就不能继承其他类了，后面两种可以；
 * 2. 使用后两种方式可以多个线程共享一个target；
 * 3. Callable比Runnable多一个返回值，并且call()方法可以抛出异常。
 */
public class ThreeWayOfThread {

	public static void main(String[] args) {
		//第一种实现方式
		Thread1 t11 = new Thread1();
		Thread1 t12 = new Thread1();
		Thread1 t13 = new Thread1();

		//第二种实现方式
		Thread2 t21 = new Thread2();
		Thread2 t22 = new Thread2();
		Thread2 t23 = new Thread2();
		
		Thread t211 = new Thread(t21);
		Thread t212 = new Thread(t21);
		Thread t213 = new Thread(t21);
		
		//第三种实现
		Thread3 t31 = new Thread3();
		Thread3 t32 = new Thread3();
		Thread3 t33 = new Thread3();
		
		FutureTask<String> f1 = new FutureTask<>(t31);
		FutureTask<String> f2 = new FutureTask<>(t31);
		FutureTask<String> f3 = new FutureTask<>(t31);
		
		Thread t311 = new Thread(f1);
		Thread t312 = new Thread(f2);
		Thread t313 = new Thread(f3);
		
		int n = 2;
		switch(n) {
			case 1:
				t11.start();
				t12.start();
				t13.start();
				break;
			case 2:
				t211.start();
				t212.start();
				t213.start();
				break;
			case 3:
				t311.start();
				t312.start();
				t313.start();
				break;
			default:
				break;
		}
			
	}

}
//1. 继承Thread
class Thread1 extends Thread {
	
	private int n = 5;
	
	@Override
	public void run() {
		while(n > 0) {
			System.out.println("name:" + this.getName() + ", n:" + n);
			n--;
		}
	}
}
//2. 实现Runnable接口
class Thread2 implements Runnable {
	
	private volatile int n = 5; 
	
	@Override
	public void run() {
		System.out.println("进入" + Thread.currentThread().getName() + "线程");
		while(n > 0) {
			//n--;
			System.out.println("name:" + Thread.currentThread().getName() + ", n:" + n);
			n--;
		}
	}
}
//3. 实现Callable接口
class Thread3 implements Callable<String> {
	
	private int n = 5;

	@Override
	public String call() throws Exception {
		while(n > 0) {
			System.out.println("name:" + Thread.currentThread().getName() + ", n:" + n);
			n--;
		}
		return String.valueOf(n);
	}
	
}

