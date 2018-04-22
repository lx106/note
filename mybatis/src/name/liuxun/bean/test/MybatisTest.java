package name.liuxun.bean.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import name.liuxun.bean.Department;
import name.liuxun.bean.Employee;
import name.liuxun.dao.DepartmentMapper;
import name.liuxun.dao.EmployeeMapper;
import name.liuxun.dao.EmployeeMapperAnnotation;
import name.liuxun.dao.EmployeeMapperDSQL;
import name.liuxun.dao.EmployeeMapperPlus;

public class MybatisTest {

	public SqlSessionFactory getSqlSessionFactory() throws Exception{
		String resource = "mybatis-config.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(is);
	}
	
	@Test
	public void test() throws IOException{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();

		try {
			Employee emp = openSession.selectOne("name.liuxun.bean.selectEmp", 1);
			System.out.println(emp);
		} finally {
			openSession.close();

		}
		
	}
	@Test
	public void test2() throws Exception{
		
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = sqlSessionFactory.openSession();

		try {
			 EmployeeMapper  employeeMapper	 = openSession.getMapper(EmployeeMapper.class);
			 Employee emp = employeeMapper.getEmployeeById(1);
			System.out.println(emp);
		} finally {
			openSession.close();

		}
	}
	@Test
	public void test3() throws Exception{
		SqlSessionFactory sqlSessionFactory	= getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		
		try {
			
			EmployeeMapperAnnotation em = openSession.getMapper(EmployeeMapperAnnotation.class);
			Employee emp = em.getEmployeeById(1);
			System.out.println(emp);
			
		} finally {
			openSession.close(); 
		}
	}
	@Test
	public void test4() throws Exception{
		SqlSessionFactory sqlSessionFactory	= getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		
		try {
			
			EmployeeMapper em = openSession.getMapper(EmployeeMapper.class);
			Employee e = new Employee("hh","M","1234@qq.com");
			em.addEmp(e);
			System.out.println(e.getId());
			openSession.commit();
			
		} finally {
			openSession.close(); 
		}
	}
	@Test
	public void test5() throws Exception{
		SqlSessionFactory sqlSessionFactory	= getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		
		try {
			
			EmployeeMapper em = openSession.getMapper(EmployeeMapper.class);
			Employee e = new Employee("liuxunliuxun", "M", "123@qq.com");
			e.setId(1);
			em.updateEmp(e);
			openSession.commit();
			
		} finally {
			openSession.close(); 
		}
	}
	@Test
	public void test6() throws Exception{
		SqlSessionFactory sqlSessionFactory	= getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		//SqlSession openSession = sqlSessionFactory.openSession(true); //会自动提交
		try {
			
			EmployeeMapper em = openSession.getMapper(EmployeeMapper.class);
			em.deleteEmpById(3);
			openSession.commit();
			
		} finally {
			openSession.close(); 
		}
	}
	@Test
	public void test7() throws Exception{
		SqlSessionFactory sqlSessionFactory	= getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		//SqlSession openSession = sqlSessionFactory.openSession(true); //会自动提交
		try {
			
			EmployeeMapper em = openSession.getMapper(EmployeeMapper.class);
			Employee e = em.getEmployeeByIdAndName(4,"hh");
			System.out.println(e);
			
		} finally {
			openSession.close(); 
		}
	}
	@Test
	public void test8() throws Exception{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
	   try {
		Employee e = new Employee("liuxunliuxun", "M", "123@qq.com");
		EmployeeMapper em = openSession.getMapper(EmployeeMapper.class);
		Employee e1 = em.getEmployeeByBean(e);
		System.out.println(e1.getId());
	   } finally {
	  } 
		
	}
	@Test
	public void test9() throws Exception{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
	   try {
		HashMap<String, String> map = new HashMap<>();
		map.put("id", "5");
		map.put("last_name", "hh");
		map.put("table_name", "tbl_employee");
		EmployeeMapper em = openSession.getMapper(EmployeeMapper.class);
		Employee e1 = em.getEmployeeByMap(map);
		System.out.println(e1);
	   } finally {
	  } 
		
	}
	@Test
	public void test10() throws Exception{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
	   try {
		
		EmployeeMapper em = openSession.getMapper(EmployeeMapper.class);
		Employee e1 = em.getEmployeeByGenderAndEmail("F","1234@qq.com");
		System.out.println(e1);
	   } finally {
	  } 
	}
	@Test
	public void test11() throws Exception{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
	   try {
		
		EmployeeMapper em = openSession.getMapper(EmployeeMapper.class);
		Employee e1 = em.getEmployeeByList(Arrays.asList(1,4));
		System.out.println(e1);
	   } finally {
	  } 
	}
	@Test
	public void test12() throws Exception{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
	   try {
		
		EmployeeMapper em = openSession.getMapper(EmployeeMapper.class);
		List<Employee> emps = em.getEmpsByLastNameLike("h%");
		System.out.println(emps.size());
		System.out.println(emps);
	   } finally {
		   openSession.close();
	  } 
	}
	@Test
	public void test13() throws Exception{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
	   try {
		
		EmployeeMapper em = openSession.getMapper(EmployeeMapper.class);
		HashMap<String,Object> map = em.getMap(1);
		for (String key : map.keySet()) {
			System.out.println(key+"=" +map.get(key));
		}
		System.out.println(map);
	   } finally {
		   openSession.close();
	  } 
	}
	@Test
	public void test14() throws Exception{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
	   try {
		
		EmployeeMapper em = openSession.getMapper(EmployeeMapper.class);
		HashMap<Integer,Employee> emps = em.getMaps("h%");
		System.out.println(emps.size());
		System.out.println(emps);
	   } finally {
		   openSession.close();
	  } 
	}
	@Test
	public void test15() throws Exception{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
	   try {
		
		   EmployeeMapperPlus em = openSession.getMapper(EmployeeMapperPlus.class);
		   Employee emp = em.getEmpById(1);
		   System.out.println(emp);
	   } finally {
		   openSession.close();
	  } 
	}
	@Test
	public void test16() throws Exception{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
	   try {
		
		   EmployeeMapperPlus em = openSession.getMapper(EmployeeMapperPlus.class);
		   Employee emp = em.getEmployeeAndDept(1);
		   System.out.println(emp);
	   } finally {
		   openSession.close();
	  } 
	}
	@Test
	public void test17() throws Exception{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
	   try {
		
		   EmployeeMapperPlus em = openSession.getMapper(EmployeeMapperPlus.class);
		   Employee emp = em.getEmployeeAndDept2(1);
		   System.out.println(emp);
	   } finally {
		   openSession.close();
	  } 
	}
	@Test
	public void test18() throws Exception{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
	   try {
		
		   DepartmentMapper dm = openSession.getMapper(DepartmentMapper.class);
		   Department dp = dm.getDepartment(1);
		   System.out.println(dp);
	   } finally {
		   openSession.close();
	  } 
	}
	@Test
	public void test19() throws Exception{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
	   try {
		
		   EmployeeMapperPlus dm = openSession.getMapper(EmployeeMapperPlus.class);
		   Employee dp = dm.getEmpByIdStep(1);
		   System.out.println(dp.getEmail());
		   //System.out.println(dp);
	   } finally {
		   openSession.close();
	  } 
	}
	@Test
	public void test20() throws Exception{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
	   try {
		
		   DepartmentMapper dm = openSession.getMapper(DepartmentMapper.class);
		   Department dp = dm.getDeptAndEmps(1);
		   System.out.println(dp.getDeptName());
		   //System.out.println(dp);
	   } finally {
		   openSession.close();
	  } 
	}
	@Test
	public void test21() throws Exception{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
	   try {
		
		   EmployeeMapperPlus em = openSession.getMapper(EmployeeMapperPlus.class);
		   Employee dp = em.getEmpsByDisc(4);
		   System.out.println(dp);
		   //System.out.println(dp);
	   } finally {
		   openSession.close();
	  } 
	}
	@Test
	public void test22() throws Exception{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
	   try {
		
		   EmployeeMapperDSQL em = openSession.getMapper(EmployeeMapperDSQL.class);
		   Employee e = new Employee();
		   e.setLastName("");
		   //e.setGender("M");
		   //e.setEmail("123@qq.com");
		   List<Employee> emps = em.getEmpsByCondition(e);
		   System.out.println(emps);
	   } finally {
		   openSession.close();
	  } 
	}
	@Test
	public void test23() throws Exception{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
	   try {
		
		   EmployeeMapperDSQL em = openSession.getMapper(EmployeeMapperDSQL.class);
		   Employee e = new Employee();
		   //e.setId(1);
		   //e.setLastName("hh");
		   e.setGender("M");
		   e.setEmail("123@qq.com");
		   List<Employee> emps = em.getEmpsByChoose(e);
		   System.out.println(emps);
		  // System.out.println(e);
	   } finally {
		   openSession.close();
	  } 
	}
	@Test
	public void test24() throws Exception{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
	   try {
		
		   EmployeeMapperDSQL em = openSession.getMapper(EmployeeMapperDSQL.class);
		   Employee e = new Employee();
		   e.setId(1);
		   e.setLastName("liuxun");
		   e.setGender("M");
		   e.setEmail("106@qq.com");
		   em.updateEmp(e);
		  // System.out.println(e);
		  openSession.commit(); 
	   } finally {
		   openSession.close();
	  } 
	}
	@Test
	public void test25() throws Exception{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
	   try {
		
		   EmployeeMapperDSQL em = openSession.getMapper(EmployeeMapperDSQL.class);
		   List<Employee> list= em.getEmployeeByIds(Arrays.asList(1,2,3,4));
		   for (Employee employee : list) {
			System.out.println(employee);
		}
	   } finally {
		   openSession.close();
	  } 
	}
	@Test
	public void test26() throws Exception{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
	   try {
		
		   EmployeeMapperDSQL em = openSession.getMapper(EmployeeMapperDSQL.class);
		   List<Employee> list= Arrays.asList(new Employee(null,"abc","abc@qq.com", "F",new Department(1, "开发部")),
											  new Employee(null,"tfg","tgf@qq.com", "F", new Department(1, "开发部")),
											  new Employee(null,"ooo","ooo@qq.com", "F", new Department(1, "开发部")));
		   em.insertEmps(list);
		  
		   openSession.commit();
	   } finally {
		   openSession.close();
	  } 
	}
	@Test
	public void test27() throws Exception{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
	   try {
		
		   EmployeeMapperDSQL em = openSession.getMapper(EmployeeMapperDSQL.class);
		   Employee e = new Employee();
		   e.setLastName("a");
		   List<Employee> emps= em.testInnerParams(null);
		   emps.forEach(System.out::println);
	   } finally {
		   openSession.close();
	  } 
	}
	@Test
	public void test28() throws Exception{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
	   try {
		
		   EmployeeMapper em = openSession.getMapper(EmployeeMapper.class);
		   Employee e= em.testFirstLevelCache(1);
		   System.out.println(e);
		   Employee e2 = em.testFirstLevelCache(1);
		   System.out.println(e);
		   System.out.println(e==e2);
	   } finally {
		   openSession.close();
	  } 
	}
	@Test
	public void testSecondLevelCache() throws Exception{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession1 = sqlSessionFactory.openSession();
		SqlSession openSession2 = sqlSessionFactory.openSession();
	   try {
		   EmployeeMapper em1 = openSession1.getMapper(EmployeeMapper.class);
		   EmployeeMapper em2 = openSession2.getMapper(EmployeeMapper.class);
		   
		   Employee e1= em1.getEmployeeById(1);
		   System.out.println(e1.getEmail());
		   openSession1.close();
		   Employee e2= em2.getEmployeeById(1);
		   System.out.println(e2.getEmail());
		   
		   System.out.println(e1==e2);
		  
	   } finally {
		   
		   openSession2.close();
	  } 
	}
}

