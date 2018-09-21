package com.test.thread;

public class Mytask implements Runnable {
	private int total = 20;
	Object obj = new Object();

	@Override
	public synchronized void run() {
		try {
				while (total >= 0) {
					System.out.println(Thread.currentThread().getName() + "出售第" + total + "张车票!");
					Thread.sleep(1000);
					sub();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int sub() {
		return total -= 1;
	}
}
