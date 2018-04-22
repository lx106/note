package name.liuxun;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import org.junit.Test;

/**
 * 1. ͨ�� Channel ��������
 * SelectableChannel
 *   SocketChannel
 *   ServerSocketChannel
 *   DatagramChannel
 *     
 *     Pipe.SinkChannel
 *     Pipe.SourceChannel
 *     
 * 2. ������ Buffer �������ݵĴ�ȡ
 * 
 * 3. ѡ���� Selector SelectableChannel ��·������ ���ڼ��ͨ����IO״�� 
 * @author liuxun
 *
 */
public class TestNonBlockingNIO {

	
	//�ͻ���
    @Test
    public void client() throws IOException{
    	//1.�����ͻ���
    	SocketChannel client = SocketChannel.open(new InetSocketAddress("127.0.0.1",9999));
    	//2.�л�������ģʽ
    	client.configureBlocking(false);
    	//3. ���仺����
    	ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
    	//4.д�����ݵ������� 
    	Scanner scanner = new Scanner(System.in);
    	while(scanner.hasNext()){
    		String str = scanner.nextLine();
    		byteBuffer.put((new Date().toString()+"\n"+ str).getBytes());
    		byteBuffer.flip();
    		client.write(byteBuffer);
    		byteBuffer.clear();
    	}
    	
    	client.close();
    }
    //�����
    @Test
    public void server() throws IOException{
      //1. ���������
      ServerSocketChannel serverSocketChannel = ServerSocketChannel.open().bind(new InetSocketAddress(9999));
      //2. �л�������ģʽ
      serverSocketChannel.configureBlocking(false);
      //3. ��ȡѡ����
      Selector selector = Selector.open();
      //4. ��ͨ����ѡ������ 
      serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
      //5.��ѯʽ�Ļ�ȡ�Ѿ�׼��������״̬
      while(selector.select()>0){
    	  
    	 Iterator<SelectionKey> it = selector.selectedKeys().iterator();
    	 
    	 while(it.hasNext()){
    		 
    		 SelectionKey selectionKey = it.next();
    		 
    		 if(selectionKey.isAcceptable()){
    			 
    			 SocketChannel socketChannel = serverSocketChannel.accept();
    			 socketChannel.configureBlocking(false);
    			 socketChannel.register(selector, SelectionKey.OP_READ);
    			 
    		 }else if(selectionKey.isReadable()){
    			 
    			 SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
    			 
    			 ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
    			 
    			 int len ;
    			 while((len = socketChannel.read(byteBuffer)) >0){
    				 byteBuffer.flip();
    				 System.out.println(new String(byteBuffer.array(),0,len));
    				 byteBuffer.clear();
    			 }
    		 }
    		 
    		 it.remove();
    	 }
      }
      
    }
}
