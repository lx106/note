package name.liuxun.dao;

import name.liuxun.bean.Department;

public interface DepartmentMapper {
 
	public Department getDepartment(Integer id);
	
	public Department getDeptAndEmps(Integer id);
}
