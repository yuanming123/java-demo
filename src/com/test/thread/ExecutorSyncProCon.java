package com.test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * synchronized实现生产者消费者测试类
 * @author Administrator
 * @date 2018年9月21日
 */
public class ExecutorSyncProCon {
	public static void main(String[] args) {
		SyncPool pool = new SyncPool();
		ExecutorService cache = Executors.newCachedThreadPool();
		for(int i=0; i<20; i++) {
			SyncProvider provider = new SyncProvider(pool);
			SyncConsumer consumer = new SyncConsumer(pool);
			cache.execute(provider);
			cache.execute(consumer);
		}
	}
}
