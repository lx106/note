package name.liuxun;

/**
 * @author liuxun
 *
 * 1. ������ͨͬ������ �����߳� ��׼��ӡ one two
 * 
 * 
 * 
 * 
 * 
 * 
 */
public class �̰߳��� {

	public static void main(String[] args) {
		number n = new number();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(n.getOne());
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(n.getTwo());
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(n.getThree());
			}
		}).start();
	}
	
}

class number{
	
	public static synchronized  String getOne(){
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "one";
	}
	
	public synchronized  String getTwo(){
		return "two";
	}
	public String getThree(){
		return "three";
	}
}