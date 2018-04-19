package name.liuxun;

public class TestThread {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		Thread13 t = new Thread13();
		t.start();
		t.sleep(5000);
		System.out.println("fun");
	}

}
class Thread13 extends Thread{
	@Override
	public void run() {
		System.out.println("sun");
	}
}