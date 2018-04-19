package name.liuxun1;

public class MyLei implements MyFun,MyInterface{

	@Override
	public String getName() {
		return MyFun.super.getName();
	}

}
