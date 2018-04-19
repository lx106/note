package name.liuxun.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import name.liuxun.bean.Employee;

public interface EmployeeMapperDSQL {

	public List<Employee> getEmpsByCondition(Employee e);
	
	public List<Employee> getEmpsByChoose(Employee e);
	
	public void updateEmp(Employee e);
	
	public List<Employee> getEmployeeByIds(@Param("ids")List<Integer> ids);
	
	public void insertEmps(@Param("emps") List<Employee> list);
	
	public List<Employee> testInnerParams(Employee e);
}
