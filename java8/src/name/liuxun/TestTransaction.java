package name.liuxun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

public class TestTransaction {
	
	List<Transaction> transactions = null;
	
	@Before
	public void before(){
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		
		transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950)
		);
	}
	
	//1. 鎵惧嚭2011骞村彂鐢熺殑鎵�鏈変氦鏄擄紝 骞舵寜浜ゆ槗棰濇帓搴忥紙浠庝綆鍒伴珮锛�
	@Test
	public void test1(){
		transactions.stream()
					.filter((t) -> t.getYear() == 2011)
					.sorted((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue()))
					.forEach(System.out::println);
	}
	
	//2. 浜ゆ槗鍛橀兘鍦ㄥ摢浜涗笉鍚岀殑鍩庡競宸ヤ綔杩囷紵
	@Test
	public void test2(){
		transactions.stream()
					.map((t) -> t.getTrader().getCity())
					.distinct()
					.forEach(System.out::println);
	}
	
	//3. 鏌ユ壘鎵�鏈夋潵鑷墤妗ョ殑浜ゆ槗鍛橈紝骞舵寜濮撳悕鎺掑簭
	@Test
	public void test3(){
		transactions.stream()
					.filter((t) -> t.getTrader().getCity().equals("Cambridge"))
					.map(Transaction::getTrader)
					.sorted((t1, t2) -> t1.getName().compareTo(t2.getName()))
					.distinct()
					.forEach(System.out::println);
	}
	
	//4. 杩斿洖鎵�鏈変氦鏄撳憳鐨勫鍚嶅瓧绗︿覆锛屾寜瀛楁瘝椤哄簭鎺掑簭
	@Test
	public void test4(){
		transactions.stream()
					.map((t) -> t.getTrader().getName())
					.sorted()
					.forEach(System.out::println);
		
		System.out.println("-----------------------------------");
		
		String str = transactions.stream()
					.map((t) -> t.getTrader().getName())
					.sorted()
					.reduce("", String::concat);
		
		System.out.println(str);
		
		System.out.println("------------------------------------");
		
		transactions.stream()
					.map((t) -> t.getTrader().getName())
					.flatMap(TestTransaction::filterCharacter)
					.sorted((s1, s2) -> s1.compareToIgnoreCase(s2))
					.forEach(System.out::print);
	}
	
	public static Stream<String> filterCharacter(String str){
		List<String> list = new ArrayList<>();
		
		for (Character ch : str.toCharArray()) {
			list.add(ch.toString());
		}
		
		return list.stream();
	}
	
	//5. 鏈夋病鏈変氦鏄撳憳鏄湪绫冲叞宸ヤ綔鐨勶紵
	@Test
	public void test5(){
		boolean bl = transactions.stream()
					.anyMatch((t) -> t.getTrader().getCity().equals("Milan"));
		
		System.out.println(bl);
	}
	
	
	//6. 鎵撳嵃鐢熸椿鍦ㄥ墤妗ョ殑浜ゆ槗鍛樼殑鎵�鏈変氦鏄撻
	@Test
	public void test6(){
		Optional<Integer> sum = transactions.stream()
					.filter((e) -> e.getTrader().getCity().equals("Cambridge"))
					.map(Transaction::getValue)
					.reduce(Integer::sum);
		
		System.out.println(sum.get());
	}
	
	
	//7. 鎵�鏈変氦鏄撲腑锛屾渶楂樼殑浜ゆ槗棰濇槸澶氬皯
	@Test
	public void test7(){
		Optional<Integer> max = transactions.stream()
					.map((t) -> t.getValue())
					.max(Integer::compare);
		
		System.out.println(max.get());
	}
	
	//8. 鎵惧埌浜ゆ槗棰濇渶灏忕殑浜ゆ槗
	@Test
	public void test8(){
		Optional<Transaction> op = transactions.stream()
					.min((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue()));
		
		System.out.println(op.get());
	}

}