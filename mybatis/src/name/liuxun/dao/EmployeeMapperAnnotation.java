package name.liuxun.dao;

import org.apache.ibatis.annotations.Select;

import name.liuxun.bean.Employee;

public interface EmployeeMapperAnnotation {
    
	@Select("select * from tbl_employee where id = #{id}")
	public Employee getEmployeeById(Integer id);
}
