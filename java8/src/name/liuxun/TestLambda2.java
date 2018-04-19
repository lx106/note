package name.liuxun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;


import org.junit.Test;

/**
 * 
 * @author liuxun
 * java8 中引入了     “->”  操作符 也叫做Lambda 表达式操作符
 * 
 * 操作符   左边  参数列表
 * 操作符   右边  函数体
 * 
 * 语法格式一   无参数  无返回值
 *         ()  ->  System.out.println("hh");
 *         
 * 语法格式二  一个参数  无返回值       Consumer<T>   
 * 
 *         (t)  ->  System.out.println(t);   -- 一个参数小括号可以不写
 * 语法格式三   多个参数   函数体中有多行  有返回值  
 *        (x,y) -> {
				System.out.println("Lambda体有多行时 使用{}");
				return x -y;
		     };
		  如果函数体只有一行, 可以省略{}  并且可以省略 return 语句        
		 可以省略参数类型   原于编译器能通过上下文推断数据类型 
	
	Lambda 表达式 需要函数式接口的支持  函数式接口 也就是接口中只有一个抽象方法 使用标签@FunctionalInterface修饰 可以检查函数式接口      
 */         
public class TestLambda2 {
    
	/*
	 * 自然排序 Comparable 实现该接口的有 String Integer Character Double 等
	 * 定制排序 Comparator 
	 * */
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
				System.out.println("无参数 无返回值");
				//System.out.println(num);
			}
		};
		r.run();
		System.out.println("---------------------------");
		
		Runnable r2 = () -> System.out.println("无参数 无返回值");
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
		consumer.accept("江南");
	}
	@Test
	public void test2(){
		
//		Comparator<Integer> cp = (x,y) -> {
//			System.out.println("Lambda体有多行时 使用{}");
//			return x -y;
//		};
		Comparator<Integer> cp = (Integer x,Integer y) -> {
			System.out.println("Lambda体有多行时 使用{}");
			return x -y;
		};
		
	}
	public void test5(){
		String[] str = {"A","B"}; 
//		String[] str1 = null;
//		str1 = {"A","B"};  这段代码会报错  因为不能类型推断
		List<String> list = new ArrayList<>(); // 因为类型推断  这里可以不写 ，对于类型推断 Java8 以前的版本可能不支持
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
