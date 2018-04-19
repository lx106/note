package name.liuxun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * 
 * @author liuxun
 *  ���ڶԼ��� ���� ���� ���� ӳ�� ��Ƭ �Ȳ���
 *  1 ������
 *  2 �м����
 *  3 ��ֹ����
 */
public class ǿ���StreamAPI {

	@Test
	public void test1(){
		// ��һ�ַ�ʽ  ͨ��Collection �����ṩ�� stream() ����
		List<Employee> emps = new ArrayList<>();
		Stream<Employee> s1 = emps.stream();
		// �ڶ��� ͨ��Arrays�ľ�̬����stream()
		Employee[] emps2 = new Employee[10];
		Stream<Employee> s2 = Arrays.stream(emps2);
		// ������ ͨ�� 
		Stream<Employee> s3 = Stream.of(new Employee(),new Employee());
		// ������ ���������� ����
		int x =10;
		Stream<Integer> s4 = Stream.iterate(x, (y) -> y +2);
				s4.limit(0)
				  .forEach(System.out::println);
		// ����
		Stream.generate(Math::random).limit(100)
		      .forEach(System.out::println) ; 	
		
	}
	List<Employee> emps = Arrays.asList(new Employee("AAA", 30, 8000),
			new Employee("maozhi", 27, 9000),
			new Employee("liuxun", 24, 9000),
			new Employee("ww", 23, 7000));
	@Test
	public void test2(){ //�м��������ִ���κβ���  ֻ����ֹ�����Ż�һ��ִ�� �����м����  ����� �ӳ���ֵ
		emps.stream().filter((x) -> x.getAge()==23)
		.limit(2) // limit Ϊ��·����
		.distinct()
		.forEach(System.out::println);
	}
}
