package name.liuxun1;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneOffset;

import org.junit.Test;
/**
 * 
 * @author liuxun
 * 
 * 时间戳 Instant
 * 时间类    LocalTime LocalDate LocalDateTime
 */
public class TestLocalDateTime {

	// Duration
	@Test 
	public void test1(){
		LocalDateTime l1 =LocalDateTime.of(2018, 8, 8, 8, 8, 8);	
		LocalDateTime l2 =LocalDateTime.of(2019, 9, 9, 9, 10, 9);	
		
		System.out.println(Duration.between(l1, l2).toDays());
		System.out.println(Duration.between(l1, l2).toMinutes());
		
		LocalDate ld1 = LocalDate.of(2018, 8, 8);
		LocalDate ld2 = LocalDate.of(2018, 8, 12);
		int i = Period.between(ld1, ld2).getDays();
		System.out.println(i);
	
	}
	
	@Test
	public void test(){
		Instant i = Instant.now(); //默认获取UTC 时区
		System.out.println(i);
		
		OffsetDateTime odt = i.atOffset(ZoneOffset.ofHours(8)); //获取中国时区
		System.out.println(odt);
		
		System.out.println(i.toEpochMilli()); //时间戳
		
		Instant j = Instant.ofEpochMilli(1000);
		System.out.println(j.toEpochMilli());
	}
	
	public static void main(String[] args) {
		LocalDate ld = LocalDate.now();
		LocalTime lt = LocalTime.now();
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ld);
		System.out.println(lt);
		System.out.println(ldt);
		
		LocalDateTime dt =LocalDateTime.of(2018, 8, 8, 8, 8, 8);
		
		System.out.println(dt);
		System.out.println(dt.plusYears(1));
		
		System.out.println(dt.getHour());
	}
}
