package name.liuxun;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * fork join 测试
 */
public class Fork_Join extends RecursiveTask<Long>{

	private static final long serialVersionUID = 1L;
	private long start;                   //开始值
	private long end;                     //结束值
	private static long threshold = 10000;  //临界值
	
	public Fork_Join(long start, long end) {
		super();
		this.start = start;
		this.end = end;
	}
	
	@Override
	protected Long compute() {
		long sum =0 ;
		if(end -start <= threshold){
			for(long i = start; i<=end ;i++){
				sum += i;
			}
			return sum;
		}else{
			long mid = (start + end )/2;
			Fork_Join fk1 = new Fork_Join(start, mid);
			Fork_Join fk2 = new Fork_Join(mid+1, end); 
			
			fk1.fork();  // fork 拆分更小的任务
			fk2.fork();
			
		return fk1.join() + fk2.join(); // join 对 Fork_Join(start,end).compute() 这次任务
		                                // 拆分的二个小任务统计
	}
   }
  
   public static void main(String[] args) {
	   
	   /*Instant start = Instant.now();
	   long sum = new Fork_Join(1L, 10000000000L).compute(); 
	   Instant end = Instant.now();
	   System.out.println(sum +"  fork/join耗时："+Duration.between(start, end).toMillis());
       */
	   // 加入线程池执行
	   ForkJoinPool pool = new ForkJoinPool();
	   ForkJoinTask<Long> task = new Fork_Join(1L, 10000000000L);
	  
	   Instant start = Instant.now();
	   long sum = pool.invoke(task);
	   Instant end = Instant.now();
	   System.out.println(sum +"  fork/join耗时："+Duration.between(start, end).toMillis());

	   
	   Instant start2 = Instant.now();
	   long sum2 = 0;
	   for (long i = 1L; i <= 10000000000L; i++) {
		   sum2 += i;
	   }
	   Instant end2 = Instant.now();
	   System.out.println(sum2 +"  for循环耗时："+Duration.between(start2, end2).toMillis());
	   
	   
	   // 使用 java8 API 
	   Instant start3 = Instant.now();
	   long sum3 = 0;
	   sum3 = LongStream.rangeClosed(1L, 10000000000L)
			   .parallel()
			   .reduce(0,Long::sum);
	   Instant end3 = Instant.now();
	   System.out.println(sum3 +"  java8API并行计算："+Duration.between(start3, end3).toMillis());
	   
   }
}
