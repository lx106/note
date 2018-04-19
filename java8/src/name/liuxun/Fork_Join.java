package name.liuxun;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class Fork_Join extends RecursiveTask<Long>{

	private static final long serialVersionUID = 1L;
	private long start;                   //��ʼֵ
	private long end;                     //����ֵ
	private static long threshold = 10000;  //�ٽ�ֵ
	
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
			
			fk1.fork();  // fork ��ָ�С������
			fk2.fork();
			
		return fk1.join() + fk2.join(); // join �� Fork_Join(start,end).compute() �������
		                                // ��ֵĶ���С����ͳ��
	}
   }
  
   public static void main(String[] args) {
	   
	   /*Instant start = Instant.now();
	   long sum = new Fork_Join(1L, 10000000000L).compute(); 
	   Instant end = Instant.now();
	   System.out.println(sum +"  fork/join��ʱ��"+Duration.between(start, end).toMillis());
       */
	   // �����̳߳�ִ��
	   ForkJoinPool pool = new ForkJoinPool();
	   ForkJoinTask<Long> task = new Fork_Join(1L, 10000000000L);
	  
	   Instant start = Instant.now();
	   long sum = pool.invoke(task);
	   Instant end = Instant.now();
	   System.out.println(sum +"  fork/join��ʱ��"+Duration.between(start, end).toMillis());

	   
	   Instant start2 = Instant.now();
	   long sum2 = 0;
	   for (long i = 1L; i <= 10000000000L; i++) {
		   sum2 += i;
	   }
	   Instant end2 = Instant.now();
	   System.out.println(sum2 +"  forѭ����ʱ��"+Duration.between(start2, end2).toMillis());
	   
	   
	   // ʹ�� java8 API 
	   Instant start3 = Instant.now();
	   long sum3 = 0;
	   sum3 = LongStream.rangeClosed(1L, 10000000000L)
			   .parallel()
			   .reduce(0,Long::sum);
	   Instant end3 = Instant.now();
	   System.out.println(sum3 +"  java8API���м��㣺"+Duration.between(start3, end3).toMillis());
	   
   }
}
