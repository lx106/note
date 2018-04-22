package name.liuxun;

import java.nio.ByteBuffer;

import org.junit.Test;

/**
 * 
 * 一.缓冲区 buffer 在java nio 中负责数据的存取，缓冲区就是数组 用于存储不同数据类型的数据
 * ByteBuffer
 * CharBuffer
 * ShortBuffer
 * IntBuffer
 * FloatBuffer
 * DoubleBuffer
 * LongBuffer
 * 统一通过 allocate()方法分配
 * @author liuxun
 * 
 * 二 . 缓冲区存取数据的二个核心方法
 *  put() 存入数据到缓冲区中
 *  get() 获取缓冲区中的数据
 * 
 * 三. 缓冲区中的四个核心属性
 * capacity 容量  代表缓冲区中最大的存储数据的容量 一旦声明不能改变
 * limit    界限  表示缓冲区中可以操作数据的大小 limit后的数据不能进行读写
 * position 位置  表示缓冲区中正在操作数据的位置
 * 
 * mark 标记 表示当前position的位置 可以通过reset 恢复到mark的位置
 * 
 * 0<= mark <= position <= limit <= capacity
 * 
 * 四   直接缓冲区与非直接缓冲区
 *  allocate 非直接缓存区 将缓冲区建立在JVM内存中
 *  allocateDirect 直接缓存区  将缓冲区建立在物理内存中
 * 
 */
public class TestBuffer {

	@Test
	public void test3(){
		ByteBuffer bb = ByteBuffer.allocateDirect(1024);
		System.out.println(bb.isDirect());
	}
	
	@Test
	public void test1() {
		String str = "1234";
	   //1. 分配一个指定大小的缓冲区	
	   ByteBuffer bb = ByteBuffer.allocate(1024);
       
       System.out.println("----------------allocate()--------------");
       System.out.println(bb.capacity());
       System.out.println(bb.limit());
       System.out.println(bb.position());
       
       //2 put 数据到缓冲区
       bb.put(str.getBytes());
       System.out.println("----------------put()--------------");
       
       System.out.println(bb.capacity());
       System.out.println(bb.limit());
       System.out.println(bb.position());
       
       //3 切换到读模式
       bb.flip(); 
       System.out.println("----------------flip()--------------");
       System.out.println(bb.capacity());
       System.out.println(bb.limit());
       System.out.println(bb.position());
       
       //4 利用get 读取缓冲区中的数据
       byte[] buffer = new byte[bb.limit()];
       bb.get(buffer);
       System.out.println(new String(buffer));
       
       System.out.println("----------------get()--------------");
       
       System.out.println(bb.capacity());
       System.out.println(bb.limit());
       System.out.println(bb.position());
       
       //5 rewind方法 可重读
       bb.rewind();
       System.out.println("----------------rewind()--------------");
       
       System.out.println(bb.capacity());
       System.out.println(bb.limit());
       System.out.println(bb.position());
       
       //6 clear() 清空缓冲区 但是缓冲区中的数据依然存在 处于 “被遗忘” 状态
       bb.clear();
       System.out.println("----------------clear()--------------");
       
       System.out.println(bb.capacity());
       System.out.println(bb.limit());
       System.out.println(bb.position());
       
       System.out.println((char)bb.get());
	}
	
	@Test
	public void test2(){
		
	  String str = "12345";
	  
	  ByteBuffer bb = ByteBuffer.allocate(1024);
	  bb.put(str.getBytes());
	  
	  bb.flip();
	  
	  byte[] buffer = new byte[bb.limit()];
	  bb.get(buffer, 0, 2);
	  System.out.println(new String(buffer));
	  
	  System.out.println(bb.position());
	  bb.mark();
	  
	  bb.get(buffer, 2, 3);
	  System.out.println(new String(buffer));
	  System.out.println(bb.position());
	  bb.reset();
	  System.out.println(bb.position());
	}
		
}
