package name.liuxun;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class 测试Fork_Join {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		calculate c = new calculate(0, 10000000000L);
		
		ForkJoinPool pool = new ForkJoinPool();
		long start1 = System.currentTimeMillis();
		pool.submit(c);
		System.out.println(c.get());
		long end1 = System.currentTimeMillis();
		System.out.println("fork/Join循环耗时"+(end1 -start1));

		pool.shutdown();
		
		
		long start = System.currentTimeMillis();
		long sum =0;
		for (long i = 0; i < 10000000000L; i++) {
			sum +=  i;
		}
		long end = System.currentTimeMillis();
		System.out.println("for循环耗时"+(end -start));
		System.out.println(sum);
		
		test2();
	}
	public static void test2(){
		Instant start = Instant.now();
		long sum = LongStream.rangeClosed(0L, 10000000000L).parallel().reduce(0L, Long::sum);
		Instant end = Instant.now();
		System.out.println("java8 :"+Duration.between(start, end).toMillis());
	}
	
}
class calculate extends RecursiveTask<Long>{

	private static final long serialVersionUID = 8685084142595285000L;

	private long start;
	private long end;
	public static final long T = 10000L;
	@Override
	protected Long compute() {
		long length = end - start;
		if(length<=T){
			long sum = 0L;
			for (long i = start; i <=end; i++) {
				sum += i;
			}
			return sum;
		}else{
			long mid = (end + start)/2;
			calculate left = new calculate(start, mid);
			left.fork();
			calculate right = new calculate(mid+1, end);
			right.fork();
			return left.join() + right.join();
		}
		
	}
	public calculate(long start, long end) {
		super();
		this.start = start;
		this.end = end;
	}
	
	
}