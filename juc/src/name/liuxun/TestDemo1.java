package name.liuxun;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestDemo1 {

	public static void main(String[] args) {
		alternateDemo demo = new alternateDemo();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i < 10; i++) {
					demo.loopA(i);
				}
			}
		},"A").start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i < 10; i++) {
					demo.loopB(i);
				}
			}
		},"B").start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i < 10; i++) {
					demo.loopC(i);
				}
			}
		},"C").start();
	}
	
}
class alternateDemo{
	private int num = 1;
	private Lock lock =new ReentrantLock() ;
	
	private Condition c1 = lock.newCondition();
	private Condition c2 = lock.newCondition();
	private Condition c3 = lock.newCondition();
	
	public void loopA(int total){
	 lock.lock();
	 try {
	   	if(num!=1){
	   		c1.await();
	   	}
	   	for (int i = 1; i <=1; i++) {
		   System.out.println(Thread.currentThread().getName()+i+total);
		}
	   	num = 2 ;
	   	c2.signal();
	 } catch (InterruptedException e) {
		e.printStackTrace();
	}finally {
     lock.unlock();
	 }  
	}
	public void loopB(int total){
		 lock.lock();
		 try {
		   	if(num!=2){
		   		c2.await();
		   	}
		   	for (int i = 1; i <=1; i++) {
			   System.out.println(Thread.currentThread().getName()+i+total);
			}
		   	num = 3 ;
		   	c3.signal();
		 } catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
	     lock.unlock();
		 }  
	}
	public void loopC(int total){
		 lock.lock();
		 try {
		   	if(num!=3){
		   		c3.await();
		   	}
		   	for (int i = 1; i <=1; i++) {
			   System.out.println(Thread.currentThread().getName()+"i"+total);
			}
		   	num = 1 ;
		   	c1.signal();
		 } catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
	     lock.unlock();
		 }  
	}
}
