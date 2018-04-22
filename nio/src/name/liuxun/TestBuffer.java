package name.liuxun;

import java.nio.ByteBuffer;

import org.junit.Test;

/**
 * 
 * һ.������ buffer ��java nio �и������ݵĴ�ȡ���������������� ���ڴ洢��ͬ�������͵�����
 * ByteBuffer
 * CharBuffer
 * ShortBuffer
 * IntBuffer
 * FloatBuffer
 * DoubleBuffer
 * LongBuffer
 * ͳһͨ�� allocate()��������
 * @author liuxun
 * 
 * �� . ��������ȡ���ݵĶ������ķ���
 *  put() �������ݵ���������
 *  get() ��ȡ�������е�����
 * 
 * ��. �������е��ĸ���������
 * capacity ����  �������������Ĵ洢���ݵ����� һ���������ܸı�
 * limit    ����  ��ʾ�������п��Բ������ݵĴ�С limit������ݲ��ܽ��ж�д
 * position λ��  ��ʾ�����������ڲ������ݵ�λ��
 * 
 * mark ��� ��ʾ��ǰposition��λ�� ����ͨ��reset �ָ���mark��λ��
 * 
 * 0<= mark <= position <= limit <= capacity
 * 
 * ��   ֱ�ӻ��������ֱ�ӻ�����
 *  allocate ��ֱ�ӻ����� ��������������JVM�ڴ���
 *  allocateDirect ֱ�ӻ�����  �������������������ڴ���
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
	   //1. ����һ��ָ����С�Ļ�����	
	   ByteBuffer bb = ByteBuffer.allocate(1024);
       
       System.out.println("----------------allocate()--------------");
       System.out.println(bb.capacity());
       System.out.println(bb.limit());
       System.out.println(bb.position());
       
       //2 put ���ݵ�������
       bb.put(str.getBytes());
       System.out.println("----------------put()--------------");
       
       System.out.println(bb.capacity());
       System.out.println(bb.limit());
       System.out.println(bb.position());
       
       //3 �л�����ģʽ
       bb.flip(); 
       System.out.println("----------------flip()--------------");
       System.out.println(bb.capacity());
       System.out.println(bb.limit());
       System.out.println(bb.position());
       
       //4 ����get ��ȡ�������е�����
       byte[] buffer = new byte[bb.limit()];
       bb.get(buffer);
       System.out.println(new String(buffer));
       
       System.out.println("----------------get()--------------");
       
       System.out.println(bb.capacity());
       System.out.println(bb.limit());
       System.out.println(bb.position());
       
       //5 rewind���� ���ض�
       bb.rewind();
       System.out.println("----------------rewind()--------------");
       
       System.out.println(bb.capacity());
       System.out.println(bb.limit());
       System.out.println(bb.position());
       
       //6 clear() ��ջ����� ���ǻ������е�������Ȼ���� ���� ���������� ״̬
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
