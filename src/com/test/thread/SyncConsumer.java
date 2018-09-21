package com.test.thread;

/**
 * synchronzed加锁机制实现消费者
 * @author Administrator
 * @date 2018年9月21日
 */
public class SyncConsumer implements Runnable{
	
	private SyncPool pool;
	
	public SyncConsumer(SyncPool pool) {
		this.pool = pool;
	}
	@Override
	public void run() {
		pool.remove();
	}
}
