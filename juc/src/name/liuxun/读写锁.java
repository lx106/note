package name.liuxun;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 
 * @author liuxun
 * ReadWriteLock
 * дд  ��д ��Ҫ����
 * ��������Ҫ����
 * 
 *  ��д�� �������ǰ����Ҳ���ڻ�������
 */
public class ��д�� {

	public static void main(String[] args) {
		ReadWrite rw = new ReadWrite();
		
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
							rw.getList().add("���"+j);
						}
					}
				}).start();
			}
		}
		
	}
	
}
class ReadWrite {
	
	private ReadWriteLock lock = new ReentrantReadWriteLock();
	
	private List<String> list = new ArrayList<String>();
	
	
	public void put(String str){
		lock.writeLock().lock();
		
		try {
			list.add(str);
		} finally {
		    lock.writeLock().unlock();
		}
	}
	public String get(int i){
		lock.readLock().lock();
		try {
			return list.get(i);
		} finally {
			lock.readLock().unlock();	
		}
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	
}