package name.liuxun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import name.liuxun.bean.Employee;
import org.junit.Test;

public class Test10  {

	@Test
	public void test2(){
		Optional<Integer> sum = emps.stream().map(x -> 1).reduce((x,y) -> x+=y);
		System.out.println(sum.get());
	}
	List<Employee> emps = Arrays.asList(new Employee("AAA", 30, 8000),
			new Employee("maozhi", 27, 9000),
			new Employee("liuxun", 24, 9000),
			new Employee("ww", 23, 7000));
	
	@Test
	public void test(){
//	  List<Integer> list = Arrays.asList(1,2,3,4,5,6);
//	  List<Integer> list2 = list.stream().map(x -> x*x).collect(Collectors.toList());
//	  list2.forEach(System.out::println);
	  
	  Integer[] ints = new Integer[]{1,2,3,4,5};
	  Integer[] ints1 = new Integer[]{};
	  Integer[] ints2 = Arrays.asList(ints).stream().map(x -> x*x).collect(Collectors.toList()).toArray(ints1);
	  
	  for (Integer integer : ints2) {
		System.out.println(integer);
	  }
	  System.out.println("=====================");
	  Arrays.stream(ints).map(x -> x*x).forEach(System.out::println);
	  
	  
	}
}
