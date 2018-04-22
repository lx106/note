package name.liuxun;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.FileSystem;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchEvent.Modifier;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

/*
 * 1 ͨ�� ����Դ�ڵ���Ŀ��ڵ������ �����仺�����е����� �䱾���洢���� 
 * 
 * 2 ͨ������Ҫʵ����
 *   java.nio.channels.Channel �ӿ�
 *           FileChannel
 *           SocketChannel
 *           ServerSocketChannel
 *           DatagramChannel
 * 3 ��ȡͨ��       
 *  ���֧��ͨ�������ṩ��getChannel()
 *  ����IO
 *  FileInputStrem/FileOutputStrem
 *  RandomAccessFile
 *  
 *  ����IO  
 *  Socket
 *  ServerSocket
 *  DatagramSocket
 *  
 *  JDK1.7 NIO.2 ��Ը���ͨ���ṩ�˾�̬����open()
 *  Files ������ newByteChannel() 
 *  
 *  4 ��ɢ  Scatter  �����ݷ�ɢ�������������
 *    �ۼ�  Gather 
 *    
 *  5.�ַ��� Charset
 *    ����  �ַ��� -> �ֽ�����  
 *    ����    �ֽ����� -> �ַ��� 
 *    
 */
public class TestChannel {
    
	@Test
	public void test6() throws IOException{
		
		Charset cs = Charset.forName("UTF-8");
		
		CharsetEncoder ce = cs.newEncoder();
		
		cs = Charset.forName("GBK");
		CharsetDecoder cd = cs.newDecoder();
		
		CharBuffer cb = CharBuffer.allocate(1024);
		cb.put("������ĸ��");
		cb.flip();
		
		ByteBuffer bb = ByteBuffer.allocate(1024);
		bb=ce.encode(cb);
		
		
		FileChannel fc = FileChannel.open(Paths.get("C:\\Users\\liuxun\\Desktop\\a.txt"), StandardOpenOption.CREATE,StandardOpenOption.WRITE,StandardOpenOption.READ);
		fc.write(bb);
		
		fc.close();
		fc = FileChannel.open(Paths.get("C:\\Users\\liuxun\\Desktop\\a.txt"),StandardOpenOption.READ);
		
		ByteBuffer bb1= ByteBuffer.allocate(1024);
		
		fc.read(bb1);
		System.out.println(bb1.position());
		bb1.flip();
		byte[] bt = new byte[2048];
		bb1.get(bt, 0, bb1.limit()); 
		
		
		System.out.println(new String(bt));
		
	}
	
	@Test
	public void test5(){
		Map<String,Charset> map = Charset.availableCharsets();
		
		for (String it : map.keySet()) {
			System.out.println(it+":"+map.get(it));
		}
		for (Entry<String,Charset> it : map.entrySet()) {
			System.out.println(it.getKey()+":" +it.getValue());
		}
	}
	
	@Test
	public void test4() throws IOException{
		RandomAccessFile raf = new RandomAccessFile("1.txt", "rw");
		FileChannel fc = raf.getChannel();
		
		ByteBuffer bb = ByteBuffer.allocate(1024);
		ByteBuffer bb1 = ByteBuffer.allocate(100);
		
		//��ɢ��ȡ
		ByteBuffer[] bbs = {bb,bb1};
		
		fc.read(bbs);
		
		for (ByteBuffer byteBuffer : bbs) {
			byteBuffer.flip();
			System.out.println(new String(byteBuffer.array(),0,byteBuffer.limit()));

		}
		
		//�ۼ�д��
	    RandomAccessFile raf1 = new RandomAccessFile("2.txt","rw");	
	    FileChannel fc1 = raf1.getChannel();
	    
	    ByteBuffer bb11 = ByteBuffer.allocate(1024);
	    bb11.put("123".getBytes());
	    bb11.flip();
	    ByteBuffer bb22 = ByteBuffer.allocate(1024);
	    bb22.put("abc".getBytes());
	    bb22.flip();
	    ByteBuffer[] bbs1 ={bb11,bb22};
	    
	    fc1.write(bbs1);
	    
	    fc1.close();
	    raf1.close();
	}
	
	//ʹ��ֱ�ӻ���������ļ��ĸ��ƣ��ڴ�ӳ���ļ���
	@Test
	public void test3() throws IOException{
		
		long start = System.currentTimeMillis();
		FileChannel in = FileChannel.open(Paths.get("F:\\������\\ubuntu-15.10-desktop-amd64.iso"), StandardOpenOption.READ);
		FileChannel out = FileChannel.open(Paths.get("F:\\������\\ubuntu.iso"),StandardOpenOption.WRITE,  StandardOpenOption.READ,StandardOpenOption.CREATE);
         
		MappedByteBuffer mbi = in.map(MapMode.READ_ONLY, 0, in.size());
		MappedByteBuffer mbo = out.map(MapMode.READ_WRITE, 0, in.size());
		
		byte[] buf = new byte[mbi.limit()];
		
		mbi.get(buf);
		mbo.put(buf);
		
		in.close();
		out.close();
		long end = System.currentTimeMillis();
		System.out.println("�ķ�ʱ�䣺"+ (end-start));
	}
	
	
	//1.����ͨ������ļ��ĸ���
	@Test
	public void test2() throws Exception{
		long start = System.currentTimeMillis();
		FileInputStream fis = new FileInputStream("F:\\������\\ubuntu-15.10-desktop-amd64.iso");
		FileOutputStream fos = new FileOutputStream("F:\\������\\ubuntu.iso");
		
		//1 ��ȡͨ��
		FileChannel fi = fis.getChannel();
		FileChannel fo = fos.getChannel();
		
		//2 ����ָ����С�Ļ�����
		ByteBuffer bb = ByteBuffer.allocate(1024);
		
		//3 �����ݴ��뻺����
		while((fi.read(bb))!= -1){
			bb.flip();
			fo.write(bb);
			bb.clear();
		}
		fi.close();
		fo.close();
		fis.close();
		fos.close();
		long end = System.currentTimeMillis();
		System.out.println("�ķ�ʱ�䣺"+ (end-start));
	}
	@Test
	public void test1() throws Exception{
		FileInputStream fis = new FileInputStream("F:\\������\\CentOS-7-x86_64-DVD-1511.iso");
		FileOutputStream fos = new FileOutputStream("F:\\������\\CentOS.iso");
		
		FileChannel fi = fis.getChannel();
		FileChannel fo = fos.getChannel();
		
		fo.transferFrom(fi, 0, fi.size());
		
		fi.close();
		fo.close();
		fis.close();
		fos.close();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
