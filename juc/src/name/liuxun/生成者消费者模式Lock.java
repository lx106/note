package name.liuxun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class 生成者消费者模式Lock {

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
class Store2 {
	
	private int food = 0;
    private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	public int getFood() {
		return food;
	}

	public void setFood(int food) {
		this.food = food;
	}
	public void consume(){
		lock.lock();
		try {
			while (food <= 0) {
				System.out.println("没有商品了");
				try {
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("消费了：" + --food);
			condition.signalAll();
		} finally {
           lock.unlock();
		}		
	}
	public  void stock(){
		
		lock.lock();
		try {
			while (food >= 1) {
				System.out.println("商品太多了");
				try {
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("生成了：" + ++food);
			condition.signalAll();
		} finally {
           lock.unlock();
		}
	}
	
	
}
class Producer2 implements Runnable{
    
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
  
	public Producer2(Store store) {
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

class Consumer2 implements Runnable{
    
	public Store store;
	
	@Override
	public void run() {
		for (int i = 0; i < 15; i++) {
			store.stock();
		}
	}
  
	public  Consumer2(Store store) {
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

 class DBHelper {  
    public static final String url = "jdbc:mysql://127.0.0.1/msg";  
    public static final String name = "com.mysql.jdbc.Driver";  
    public static final String user = "root";  
    public static final String password = "root";  
  
    public Connection conn = null;  
    public PreparedStatement pst = null;  
  
    public DBHelper(String sql) {  
        try {  
            Class.forName(name);//指定连接类型  
            conn = DriverManager.getConnection(url, user, password);//获取连接  
            pst = conn.prepareStatement(sql);//准备执行语句  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
    public void close() {  
        if(conn !=null){
        	try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// TODO: handle finally clause
			}
        }
    	try {  
            this.conn.close();  
            this.pst.close();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }  
}  
















