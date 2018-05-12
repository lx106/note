package name.liuxun;

import java.util.Optional;

import name.liuxun.bean.Employee;
import org.junit.Test;
/**
 * 
 * @author liuxun
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
