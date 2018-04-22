package name.liuxun.dao;

import java.util.List;

import name.liuxun.bean.Employee;

public interface EmployeeMapperPlus {

	public Employee getEmpById(Integer id);
	
	public Employee getEmployeeAndDept(Integer id);
	
	public Employee getEmployeeAndDept2(Integer id);
	
	public Employee getEmpByIdStep(Integer id);
	
	public List<Employee> getEmpsByDid(Integer did);
	
	public Employee getEmpsByDisc(Integer id);
}
