package name.liuxun;

import java.util.Optional;

import org.junit.Test;
/**
 * 
 * @author liuxun
 * Optional 容器类的常用方法
 * Optional.of(T t) 创建一个Optional 实例  如果t 为null  调用这个对象的方法会报错
 * Optional.ofNullable(T t) 
 * 
 */
public class TestOptional {

	@Test
	public void test(){
		Optional<Employee> op = Optional.ofNullable(null);
		
		//System.out.println(op.get());
		//Optional<Object> op2 =  Optional.empty();
		//System.out.println(op2.get());
		System.out.println(op.get());
		//System.out.println(op.orElse(new Employee("liuxun", 23, 10000)));
	}
}
