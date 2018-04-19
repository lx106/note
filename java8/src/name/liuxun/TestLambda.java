package name.liuxun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.junit.Test;

public class TestLambda {
    
	@Test
    public void test1(){
    	Comparator<Integer> cp = new Comparator<Integer>() {
    		@Override
    		public int compare(Integer o1, Integer o2) {
    			return 01-02;
    		}
    	};
    	TreeSet<Integer> treeSet = new TreeSet<>(cp);
    }
	@Test
	public void test2(){
		Comparator<Integer> cp = (x,y) -> x-y;
    	TreeSet<Integer> treeSet = new TreeSet<>(cp);
	}
	
	List<Employee> emps = Arrays.asList(new Employee("AAA", 30, 8000),
										new Employee("maozhi", 27, 9000),
										new Employee("liuxun", 24, 9000),
										new Employee("ww", 23, 7000));
	
	
	//传统过滤集合方式  存在缺陷 如果有新需求 添加过滤条件 工资大于等于9000 这时候要么改这个方法 要么添加新方法
	//例如淘宝 客户查询东西的过过滤条件多变
	public List<Employee> getEmpsByAge(List<Employee> list){
		Comparator<Employee> cp = (x,y) -> x.getAge() - y.getAge();
		List<Employee> emps = new ArrayList<Employee>();
		for (Employee e : list) {
			if(e.getAge()>24){
				emps.add(e);
			}
		}
		return emps;
	}
	@Test
	public void test3(){
		 List<Employee> list = getEmpsByAge(emps);
         for (Employee employee : list) {
			System.out.println(employee);
		}		 
	}
	// 这种方式 就要写很多的接口实现类
	@Test
	public void test4(){
		
		MyPredicate<Employee> p = new MyPredicate<Employee>() {
			@Override
			public boolean test(Employee e) {
			  if(e.getAge()<=27 && e.getSalary()>8000){
				  return true;  
			  }
			  return false;
			}
			
		};
		List<Employee> list = getEmps4(emps,p);
		for (Employee employee : list) {
			System.out.println(employee);
		}
	}
	private List<Employee> getEmps4(List<Employee> emps2, MyPredicate<Employee> p) {
		List<Employee> list = new ArrayList<>();
		for (Employee e : emps2) {
			if(p.test(e)){
				list.add(e);
			}
		}
		return list;
	}
	
	@Test //优化方式一 使用策略模式
	public void test5(){
		
		List<Employee> list = getEmps4(emps,new MyPredicate<Employee>() {
			@Override
			public boolean test(Employee e) {
				if(e.getAge()==24){
					return true;
				}
				return false;
			}
		});
		for (Employee employee : list) {
			System.out.println(employee);
		}
	}
	@Test //优化方式二 Lambda表达式
	public void test6(){
		List<Employee> list = getEmps4(emps, (e) -> e.getAge() ==30);
		list.forEach(System.out::println);
	}
	@Test // 优化方式三 Stream API 
	public void test8(){
//		Stream<Employee> list = emps.stream().filter((e) -> e.getSalary()==9000);
//		list.forEach(System.out::println);  
		emps.stream().filter((e) -> e.getSalary() ==9000)
		    .limit(1) 
			.forEach(System.out::println);
		
		System.out.println("---------------");
		
		emps.stream().map(Employee::getSalary).forEach(System.out::println);
	}

}
