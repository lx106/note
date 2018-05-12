package name.liuxun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;


import name.liuxun.bean.Employee;
import org.junit.Test;


public class TestLambda2 {

	@Test
	public void test9(){
		 //emps.stream().sorted().forEach(System.out::println);
		
//		emps.stream().sorted((x,y) -> {
//			if(x.getAge()==y.getAge()){
//				return  Double.compare(x.getSalary(), y.getSalary());
//			}else{
//				return Integer.compare(x.getAge(), y.getAge());
//			}
//		}).forEach(System.out::println);
		
		emps.stream().sorted((x,y) -> {
			if(x.getAge()>y.getAge()){
				return 1;
			}else if(x.getAge()== y.getAge()){
				return Double.compare(x.getSalary(), y.getSalary());
			}else{
			  return -1;
			}
			
		}).forEach(System.out::println);
		 
	}
	
	
	@Test
	public void test8(){
		List<Object> list = new ArrayList<>();
		list.add("aa");
		list.add("bb");
		list.add(new Employee());
		List<String> list1 = Arrays.asList("aaa","bbb","ccc","ddd");
		list.addAll(list1);
		
		for (Object object : list) {
			System.out.println(object);
		}
	}
	@Test
	public void test7(){
		
	
		List<String> list = Arrays.asList("aaa","bbb","ccc","ddd");
		
		//list.stream().map((x) -> x.toUpperCase()).forEach(System.out::println);
		
		//emps.stream().map(Employee::getName).forEach(System.out::println);
		
//		Stream<Stream<Character>> ssm = list.stream().map(TestLambda2::chas);
//		ssm.forEach(sm -> {sm.forEach(System.out::println);});
        
		list.stream().flatMap(TestLambda2::chas).forEach(System.out::println);
        
	}
	public static Stream<Character> chas(String str){
		List<Character> list = new ArrayList<>();
		for (Character character : str.toCharArray()) {
			list.add(character);
		}
		return list.stream();
	}
	@Test
	public void test(){
		 int num = 0;
		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println("????? ??????");
				//System.out.println(num);
			}
		};
		r.run();
		System.out.println("---------------------------");
		
		Runnable r2 = () -> System.out.println("????? ??????");
		r2.run();
		//System.out.println(num++);
	}
	List<Employee> emps = Arrays.asList(new Employee("AAA", 30, 8000),
			new Employee("maozhi", 27, 9000),
			new Employee("liuxun", 24, 1900),
			new Employee("liuxun", 24, 19000),
			new Employee("liuxun", 24, 9000),
			new Employee("ww", 23, 7000));
	@Test
	public void test1(){
		Consumer<String> consumer = x -> System.out.println(x);
		//Consumer<String> consumer = (x) -> System.out.println(x);
		consumer.accept("????");
	}
	@Test
	public void test2(){
		
//		Comparator<Integer> cp = (x,y) -> {
//			System.out.println("Lambda???ж???? ???{}");
//			return x -y;
//		};
		Comparator<Integer> cp = (Integer x,Integer y) -> {
			System.out.println("Lambda???ж???? ???{}");
			return x -y;
		};
		
	}
	public void test5(){
		String[] str = {"A","B"}; 
//		String[] str1 = null;
//		str1 = {"A","B"};
		List<String> list = new ArrayList<>();
	}
	@Test
	public void test6(){
		
		Integer i = getValue(10, (x) -> x*x );
		Integer j = getValue(10, (x) -> x*2);
		System.out.println(i);
		System.out.println(j);
	}
	public Integer getValue(Integer i,MyFun<Integer> fun){
		return fun.getValue(i);
	}
}
