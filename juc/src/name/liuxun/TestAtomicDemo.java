package name.liuxun;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomicDemo {

	public static void main(String[] args) {
		AtomicDemo ad = new AtomicDemo();
		for(int i = 1; i<=10 ;i++){
			new Thread(ad).start();
		}
	}
}
 class AtomicDemo implements Runnable{
    
	private  AtomicInteger count =  new AtomicInteger(0);
	@Override
	public void run() {
		try {
			Thread.sleep(200);
			System.out.println(getCount());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public int getCount() {
		return count.getAndIncrement();
	}
	
	
}