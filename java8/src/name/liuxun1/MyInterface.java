package name.liuxun1;

public interface MyInterface {

	default String getName(){
		return "����MyInterface";
	}
	public static void show(){
		System.out.println("������ĸ�� �ӿ��о�Ȼ������Ĭ�Ϸ����;�̬����");
	}
}
