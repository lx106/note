package name.liuxun;

import java.util.*;
import java.util.stream.Collectors;

import name.liuxun.bean.Employee;
import org.junit.Test;

public class TestStream {
  
	@Test
	public void test6(){
		String str =emps.stream().map(Employee::getName).collect(Collectors.joining("-","S","E"));
		System.out.println(str);
	}
	
	@Test
	public void test5(){
		DoubleSummaryStatistics ds= emps.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
	    System.out.println(ds.getAverage());
	    System.out.println(ds.getMax());
	}
	
	@Test
	public void test4(){
	    Map<String, Map<String, List<Employee>>> gp =
		emps.stream().collect(Collectors.groupingBy(Employee::getName, Collectors.groupingBy((e) -> {
			if(((Employee) e).getAge()==27){
				return "27";
			}else{
				return "��27";
			}
		})));
	    System.out.println(gp);
	}
	
	@Test
	public void test3(){
	 Map<String, List<Employee>> group=	emps.stream().collect(Collectors.groupingBy(Employee::getName));
	 System.out.println(group.entrySet());      
	}
	
	@Test
	public void test2(){
	   double sum = emps.stream().map(Employee::getSalary).reduce(0.0,(x,y)-> x += y);
	   System.out.println(sum);
	   
	   //List<String> list = emps.stream().map(Employee::getName).collect(Collectors.toList());
	   Set<String> set = emps.stream().map(Employee::getName).collect(Collectors.toSet());
	   System.out.println(set);
	   
	   double avg = emps.stream().map(Employee::getSalary).collect(Collectors.averagingDouble(x -> x));
	   avg = emps.stream().collect(Collectors.averagingDouble(Employee::getSalary));
	   System.out.println(avg); 
	   
	   Optional<Double> max= emps.stream().map(Employee::getSalary).collect(Collectors.maxBy((Double::compareTo)));
	   System.out.println(max.get()); 
	}
	
	
	List<Employee> emps = Arrays.asList(
			new Employee("AAA", 30, 8000),
			new Employee("BBB", 27, 9000),
			new Employee("CCC", 27, 9000),
			new Employee("DDD", 24, 9000),
			new Employee("EEE", 24, 9000),
			new Employee("FFF", 24, 9000),
			new Employee("GGG", 23, 7000) );
	@Test
	public void test1(){
	 List<String> list = emps.stream().map(Employee::getName).collect(Collectors.toList());
	 for (String string : list) {
		System.out.println(string);
	 }
	 
	 HashMap<String, Integer> mmap = new HashMap<>();
	 emps.stream().map((x) ->{
		mmap.put(x.getName(), 1);
		return mmap;
	 });
	 System.out.println(mmap);
	 
	}
	
	
	@Test
	public void test(){
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		Optional<Integer> option = list.stream().reduce(Integer::sum);
		
		int i = list.stream().reduce(1,(x,y) -> x *= y);
		
		System.out.println(i);
		
		System.out.println(option.get());
	}
}
