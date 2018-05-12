package name.liuxun;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import name.liuxun.bean.Employee;
import org.junit.Test;

/**
 * 
 * @author liuxun
 * 方法引用   如果你要实现的Lamba体中的方法内容与已经有的方法 内容相同
 * 则可以引用 已经实现的方法
 * 方法返回值类型 以及参数类型要一致
 * 三种语法格式
 * 对象：： 实例方法名
 * 类：： 静态方法名
 * 类：：实例方法名
 * 构造器 引用
 * 数组引用
 *
 */
public class TestConsructor {

	@Test // 数组引用
	public void test6(){
		Function<Integer, String[]> fun = (x) -> new String[x];
		Function<Integer, String[]> fun1 = String[]::new;
	}
	
	@Test  //构造器引用  Constructor::new
	public void test5(){
		Supplier<Employee> sup = () -> new Employee();
		
		Supplier<Employee> sup1 = Employee::new;
	}
	
	
	@Test
	public void test(){
		PrintStream ps = System.out;
		
		Consumer<Integer> con = (x) -> System.out.println(x);
		
		Consumer<Integer> con1 = System.out::println;
		
		con1.accept(1);
	}
	
	@Test // 对象：：实例方法名
	public void test2(){
		Supplier<Double> sup = Math::random;
		System.out.println(sup.get());
		
		Employee e = new Employee("liuze", 24, 10000);
		Supplier<String> sup1 = e::getName;
		
		System.out.println(sup1.get());
	}
	@Test // 类 ：：静态方法名
	public void test3(){
		
		Comparator<String> cp = String::compareTo;
	}
	@Test // 类：：实例方法名 这种方式存在约束性
	public void test4(){
		BiPredicate<Integer, Integer> bp = Integer::equals;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
