package name.liuxun;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class TestThreadPool {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService pool = Executors.newFixedThreadPool(6);
		
		FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {

			
			@Override
			public Integer call() throws Exception {
				int sum =0;
				for (int i = 0; i < 100; i++) {
					sum += i;
				}
				return sum;
			}
		});
		
		
		pool.submit(task);
		System.out.println(task.get());
		pool.shutdown();
      
//		for (int i = 0; i < 10; i++) {
//			pool.submit(new sum100());
//		}

	}
	
}
class sum100 implements Runnable{

	private int i =50;
	@Override
	public void run() {
		while(i>=0){
			System.out.println(Thread.currentThread().getName()+":  "+i--);
		}
	}
}