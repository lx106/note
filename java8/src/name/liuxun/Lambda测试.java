package name.liuxun;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class Lambda≤‚ ‘ {

	List<Employee> emps = Arrays.asList(new Employee("AAA", 30, 8000),
										new Employee("EEE", 27, 9000),
										new Employee("DDD", 27, 9000),
										new Employee("CCC", 28, 9000),
										new Employee("CCC", 24, 9000),
										new Employee("BBB", 23, 7000));
	@Test
	public void test1(){
	
		Collections.sort(emps,(x,y) -> {
//			if(x.getAge()==y.getAge()){
//				return x.getName().compareTo(y.getName());
//			}else{
//				return x.getAge() - y.getAge();
//			}
			if(x.getAge() >y.getAge()){
				return 10;
			}else if(x.getAge() <y.getAge()){
				return 0;
			}else{
				if(x.getName().compareTo(y.getName()) >1){
					return 10;
				}
				return 0;
			}
		});
	
	
	 for (Employee employee : emps) {
		System.out.println(employee);
	 }
	}
	
}
