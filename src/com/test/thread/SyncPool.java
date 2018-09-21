package com.test.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * 消费者和生产者需要使用的池
 * @author Administrator
 * @date 2018年9月21日
 */
public class SyncPool {
	private List<String> list = new ArrayList<String>(10);
	
	public  void add() {
		synchronized (list) {
			if(list.size() >= 10) {
				try {
					System.out.println("产品数量为10,不能再生产,生产者等待...");
					list.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			list.add("A");
			System.out.println(Thread.currentThread().getName()+"生产者生产第"+list.size()+"个产品");
			list.notify();
		}
	}
	
	public void remove() {
		synchronized (list) {
			if(list.size() <= 0) {
				try {
					System.out.println("产品数量为0,不能消费,消费者等待...");
					list.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+"消费者消费第"+list.size()+"个产品");
			list.remove(0);
			list.notify();
		}
		
	}
}
