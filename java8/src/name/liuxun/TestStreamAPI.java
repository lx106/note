package name.liuxun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import name.liuxun.bean.Employee;
import org.junit.Test;

/**
 * 
 * @author liuxun
 *  用于对集合 进行 查找 过滤 映射 切片 等操作
 *  1 创建流
 *  2 中间操作
 *  3 终止操作
 */
public class TestStreamAPI {

	@Test
	public void test1(){
		// 第一种方式  通过Collection 集合提供的 stream() 方法
		List<Employee> emps = new ArrayList<>();
		Stream<Employee> s1 = emps.stream();
		// 第二种 通过Arrays的静态方法stream()
		Employee[] emps2 = new Employee[10];
		Stream<Employee> s2 = Arrays.stream(emps2);
		// 第三种 通过 
		Stream<Employee> s3 = Stream.of(new Employee(),new Employee());
		// 第四种 创建无限流 迭代
		int x =10;
		Stream<Integer> s4 = Stream.iterate(x, (y) -> y +2);
				s4.limit(0)
				  .forEach(System.out::println);
		// 生成
		Stream.generate(Math::random).limit(100)
		      .forEach(System.out::println) ; 	
		
	}
	List<Employee> emps = Arrays.asList(new Employee("AAA", 30, 8000),
			new Employee("maozhi", 27, 9000),
			new Employee("liuxun", 24, 9000),
			new Employee("ww", 23, 7000));
	@Test
	public void test2(){ //中间操作不会执行任何操作  只有终止操作才会一次执行 所有中间操作  这叫做 延迟求值
		emps.stream().filter((x) -> x.getAge()==23)
		.limit(2) // limit 为短路操作
		.distinct()
		.forEach(System.out::println);
	}
}
