package name.liuxun;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 
 * @author liuxun
 * ReadWriteLock
 * 写写  读写 需要互斥
 * 读读不需要互斥
 * 
 *  读写锁 解决了以前读读也存在互斥的清空
 */
public class 读写没锁 {

	public static void main(String[] args) {
		ReadWrite1 rw = new ReadWrite1();
		
		for(int i =1; i<=100;i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					for (String string : rw.getList()) {
						System.out.println(string);
					}
				}
			}).start();
			
			if(i==34){
				new Thread(new Runnable() {
					@Override
					public void run() {
						for (int j = 0; j <5; j++) {
							rw.getList().add("添加"+j);
						}
					}
				}).start();
			}
		}
		
	}
	
}

class ReadWrite1 {
	
	private List<String> list = new ArrayList<String>();
	
	
	public void put(String str){
		
		try {
			list.add(str);
		} finally {
		}
	}
	public String get(int i){
		try {
			return list.get(i);
		} finally {
		}
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	
}