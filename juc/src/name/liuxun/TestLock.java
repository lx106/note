package name.liuxun;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {

	public static void main(String[] args) {
		Ticket ticket = new Ticket();
		new Thread(ticket,"窗口A").start();
		new Thread(ticket,"窗口二").start();
		new Thread(ticket,"窗口M").start();
	}
}
class Ticket implements Runnable{

	private int ticket = 100;
	private Lock lock = new ReentrantLock();
	@Override
	public void run() {
		try {
			lock.lock();
			for (int i = 0; i < 100; i++) {
				if (ticket >= 1) {
					System.out.println(Thread.currentThread().getName() + ":" + --ticket);
				}
			} 
		} finally {
			lock.unlock();
		}
		
	}
	
}
