package name.liuxun;


public class TestVolatile {
	
  public static void main(String[] args) {
	  ThreadDemo threadDemo = new ThreadDemo();
	  new Thread(threadDemo).start();
	  
	  while(true){
		  if(threadDemo.getFlag()){
			  System.out.println("TestVolatile===="+ threadDemo.getFlag());
		  }
	  }
  }
  
}
class ThreadDemo implements Runnable{

	private volatile boolean  flag = false ;
	@Override
	public void run() {
	   try {
		Thread.sleep(200);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	   flag = true;
	   System.out.println("ThreadDemo:====="+flag);
	}
	public boolean getFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}