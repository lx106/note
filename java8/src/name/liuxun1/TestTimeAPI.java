package name.liuxun1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestTimeAPI {
	
	public static void main(String[] args) throws ParseException, InterruptedException, ExecutionException {
		
		/*SimpleDateFormat sdf = new SimpleDateFormat("YYYY_MM_DD");
		Callable<Date> task = new Callable<Date>() {
			@Override
			public Date call() throws Exception {
				return sdf.parse("2017_01_12");
			}
		};
		ExecutorService pool = Executors.newFixedThreadPool(6);
		List<Future<Date>> results = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			results.add(pool.submit(task));
		}
		for (Future<Date> future : results) {
			System.out.println(future.get());
		}*/
		
		/*Callable<Date> task = new Callable<Date>() {
			@Override
			public Date call() throws Exception {
				return ThreadLocalTime.getSimpleDateFormat("2017_01_12");
			}
		};
		ExecutorService pool = Executors.newFixedThreadPool(6);
		List<Future<Date>> results = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			results.add(pool.submit(task));
		}
		for (Future<Date> future : results) {
			System.out.println(future.get());
		}*/

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd");
        
		Callable<LocalDate> task = new Callable<LocalDate>() {
			@Override
			public LocalDate call() throws Exception {
				return LocalDate.parse("2017_01_12",dtf);
			}
		};
		ExecutorService pool = Executors.newFixedThreadPool(6);
		List<Future<LocalDate>> results = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			results.add(pool.submit(task));
		}
		for (Future<LocalDate> future : results) {
			System.out.println(future.get());
		}
	}
}
