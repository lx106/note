package name.liuxun;

import java.util.Optional;

import org.junit.Test;
/**
 * 
 * @author liuxun
 * Optional ������ĳ��÷���
 * Optional.of(T t) ����һ��Optional ʵ��  ���t Ϊnull  �����������ķ����ᱨ��
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
