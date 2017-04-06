package org.test.examples.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description：<br>
 * 线程池
 * 
 * @author cheng
 * @date 2017年3月30日
 *
 */
public class JavaThreadPool {

	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(3);
		Thread t1 = new MyThread("1");
		Thread t2 = new MyThread("2");
		Thread t3 = new MyThread("3");
		Thread t4 = new MyThread("4");
		Thread t5 = new MyThread("5");
		// 将线程放入池中进行执行
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		pool.execute(t4);
		pool.execute(t5);

		pool.shutdown();
	}
}

class MyThread extends Thread {

	private String name;

	public MyThread() {
	}

	public MyThread(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "正在运行:" + name);
	}
}
