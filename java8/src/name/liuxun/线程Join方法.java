package name.liuxun;

import org.junit.Test;

public class �߳�Join���� {

	@Test
	public void test1(){
		
		Runnable r1 = () ->  { 
			for (int i = 0; i < 10; i++) {
				System.out.println("####"+i);
			}
		};
		Runnable r2 = () ->  { 
			for (int i = 0; i < 10; i++) {
				System.out.println("$$$$"+i);
			}
		};
		
		r1.run();
		r2.run();
	}
	@Test
	public void test2() throws InterruptedException{
		Runnable r1 = () ->  { 
			for (int i = 0; i < 10; i++) {
				System.out.println("####"+i);
			}
		};
		Runnable r2 = () ->  { 
			for (int i = 0; i < 10; i++) {
				System.out.println("$$$$"+i);
			}
		};
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		t1.start();
		t1.join();
		t2.start();
		// ������ �߳�һ��ӡ��  Ȼ���ڴ�ӡ�̶߳�
	}
}
