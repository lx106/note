package name.liuxun1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

public class 格式化时间日期  {

	@Test
	public void test(){
		DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
		
		LocalDateTime ldt = LocalDateTime.now();
		
		String str = ldt.format(dtf);
		
		System.out.println(str);
		
		System.out.println("======================");
		
		dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println(LocalDateTime.now());
		System.out.println(ldt.format(dtf));
		
		System.out.println(dtf.parse(str));
	}
}
