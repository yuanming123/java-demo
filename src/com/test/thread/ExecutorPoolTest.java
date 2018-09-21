package com.test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * java线程池的练习
 * @author Administrator
 * @date 2018年9月21日
 */
public class ExecutorPoolTest {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Mytask());
		Thread t2 = new Thread(new Mytask());
		Thread t3 = new Thread(new Mytask());
		//创建可缓存的线程池
		ExecutorService cachePool = Executors.newCachedThreadPool();
		cachePool.execute(t1);
		cachePool.execute(t2);
		cachePool.execute(t3);
		
		//创建单线程线程池
		ExecutorService singlePool = Executors.newSingleThreadExecutor();
		singlePool.execute(t2);
		singlePool.execute(t3);
		singlePool.execute(t1);
		
		//创建固定大小的线程
		ExecutorService fixedPool = Executors.newFixedThreadPool(3);
		fixedPool.execute(t3);
		fixedPool.execute(t2);
		fixedPool.execute(t1);
		//创建周期性线程
		ExecutorService schedulePool = Executors.newSingleThreadScheduledExecutor();
		schedulePool.execute(t1);
	}
}
