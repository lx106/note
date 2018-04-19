package name.liuxun;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class 调度线程池 {

  public static void main(String[] args) throws InterruptedException, ExecutionException {
	
	 ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);
	 
	 FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {

		@Override
		public Integer call() throws Exception {
            int sum = 0;
			for (int i = 0; i <= 10; i++) {
				sum += i ;
			}
			return sum;
		}
	});
	pool.schedule(task, 3, TimeUnit.SECONDS);
	pool.shutdown();
	System.out.println(task.get());
	
  }
  
}
