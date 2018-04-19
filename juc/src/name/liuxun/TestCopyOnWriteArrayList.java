package name.liuxun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCopyOnWriteArrayList {

	public static void main(String[] args) {
		Thread1 t = new Thread1();
		for (int i = 0; i < 10; i++) {
			new Thread(t).start();
		}
	}
}
class Thread1 implements Runnable{

	private static List<String> list = Collections.synchronizedList(new ArrayList<String>() );
	
	static {
		list.add("bb");
	}
	@Override
	public void run() {
		try {
			Thread.sleep(200);
			//list.forEach(System.out::println);
//			for (String list : list) {
//				System.out.println(list);
//			}
			list.add("aa");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}