package com.test.thread;

/**
 * synchronized实现生产者
 * @author Administrator
 * @date 2018年9月21日
 */
public class SyncProvider implements Runnable{
	
	private SyncPool syncPool;
	
	public SyncProvider(SyncPool pool) {
		this.syncPool = pool;
	}
	
	@Override
	public void run() {
		syncPool.add();
	}
}
