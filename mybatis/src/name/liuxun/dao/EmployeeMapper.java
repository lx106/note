package name.liuxun.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import name.liuxun.bean.Employee;

public interface EmployeeMapper {

	public Employee getEmployeeById(Integer id);
	public Employee getEmployeeByIdAndName(@Param("id")Integer id,@Param("lastName")String lastName);
	public Employee getEmployeeByGenderAndEmail(String gender,String email);
	public void addEmp(Employee employee);
	public void updateEmp(Employee employee);
	public void deleteEmpById(Integer id);
	
	public Employee getEmployeeByBean(Employee e);
	
	public Employee getEmployeeByMap(HashMap<String,String> map);
	
	public Employee getEmployeeByList(List<Integer> ids);
	
	public List<Employee> getEmpsByLastNameLike(String lastName);
	
	
	public HashMap<String,Object> getMap(Integer id);
	
	@MapKey("id") //告诉mybatis 把id字段 作为map的 key 值
	public HashMap<Integer,Employee> getMaps(String lastName);
	
	public Employee testFirstLevelCache(Integer id);
}
