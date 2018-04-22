package name.liuxun1;

public interface MyInterface {

	default String getName(){
		return "宝安MyInterface";
	}
	public static void show(){
		System.out.println("丢你老母啊 接口中居然可以有默认方法和静态方法");
	}
}
