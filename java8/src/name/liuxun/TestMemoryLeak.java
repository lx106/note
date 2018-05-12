package name.liuxun;

import java.util.HashMap;

public class TestMemoryLeak  {

	public static void main(String[] args) {
      HashMap<Object, Object> map = new HashMap<Object,Object>();
      student s1 = new student(10,"maozhi");
      student s2 = new student(20,"liuxun");
      
      map.put(s1, s1);
      map.put(s2, s2);
      
      System.out.println(map.get(s1));
      System.out.println(map.get(s2));
      
      s1.setName("maozhimaozhi");
      
      System.out.println(map.get(s1));
      System.out.println(map.get(s2));
      System.out.println(map.size());
      
      System.out.println("---------------");
      System.out.println(map.get(new student(10, "maozhi")));
      System.out.println(map.get(new student(10, "maozhimaozhi")));
      System.out.println(map.get(new student(20,"liuxun")));
      System.out.println("------------");
//      for (Entry<Object, Object> e : map.entrySet()) {
//		 System.out.println(e.getKey()+" : "+ e.getValue());
//	  }

      map.forEach((k,v) -> System.out.println(k+" : " +v) );
	}
}
class student {
	private int id;
	private String name;
	
	
	public student() {
		super();
	}
	public student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		student other = (student) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "student [id=" + id + ", name=" + name + "]";
	}
	
}