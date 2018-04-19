package name.liuxun;

public class ������������ģʽ {

	public static void main(String[] args) {
		Store store = new Store();
		//store.setFood(8);
		
		Producer p = new Producer(store);
		Consumer c = new Consumer(store);
		
		Producer p2 = new Producer(store);
		Consumer c2 = new Consumer(store);
		
		new Thread(p).start();
		new Thread(c).start();
		
		new Thread(p2).start();
		new Thread(c2).start();
	}
	
}
class Store {
	
	private int food = 0;
    
	public int getFood() {
		return food;
	}

	public void setFood(int food) {
		this.food = food;
	}
	public synchronized void consume(){
		while(food <= 0){
			System.out.println("û����Ʒ��");
			try {
				this.wait();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("�����ˣ�"+ --food);
		this.notifyAll();
		
	}
	public synchronized void stock(){
		while(food >=1){
			System.out.println("��Ʒ̫����");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("�����ˣ�"+ ++food);
		this.notifyAll();
	}
	
	
}
class Producer implements Runnable{
    
	public Store store;
	
	@Override
	public void run() {
		for (int i = 0; i < 15; i++) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			store.consume();
		}
	}
  
	public Producer(Store store) {
		super();
		this.store = store;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}
}

class Consumer implements Runnable{
    
	public Store store;
	
	@Override
	public void run() {
		for (int i = 0; i < 15; i++) {
			store.stock();
		}
	}
  
	public  Consumer(Store store) {
		super();
		this.store = store;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}
}

















