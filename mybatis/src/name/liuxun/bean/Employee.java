package name.liuxun.bean;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("emp")
public class Employee implements Serializable{

	private static final long serialVersionUID = 2165253250420248549L;
	private String lastName;
	private Integer id;
	private String lang;
	private String email;
	private String gender;
	private Department dept;
	
	
	
	public Employee(Integer id,String lastName, String email, String gender, Department dept) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.dept = dept;
	}
	
	public Employee() {
	}
	public Employee(String lastName, Integer id, String lang, String email, String gender, Department dept) {
		super();
		this.lastName = lastName;
		this.id = id;
		this.lang = lang;
		this.email = email;
		this.gender = gender;
		this.dept = dept;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	
	public Employee(Integer id, String lastName, String gender, String email) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
	}
	public Employee(String lastName, String gender, String email) {
		super();
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
	}
	
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Employee [lastName=" + lastName + ", id=" + id + ", lang=" + lang + ", email=" + email + ", gender="
				+ gender + ", dept=" + dept + "]";
	}
	
	
}
