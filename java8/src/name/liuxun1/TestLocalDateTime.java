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
 *  全新的日期，时间类
 *Instant LocalTime LocalDate LocalDateTime Duration
 */
public class TestLocalDateTime {

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
		Instant i = Instant.now();
		System.out.println(i);
		
		OffsetDateTime odt = i.atOffset(ZoneOffset.ofHours(8));
		System.out.println(odt);
		
		System.out.println(i.toEpochMilli());
		
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
