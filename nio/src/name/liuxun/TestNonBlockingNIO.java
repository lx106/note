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
 * 1. 通道 Channel 负责连接
 * SelectableChannel
 *   SocketChannel
 *   ServerSocketChannel
 *   DatagramChannel
 *     
 *     Pipe.SinkChannel
 *     Pipe.SourceChannel
 *     
 * 2. 缓冲区 Buffer 负责数据的存取
 * 
 * 3. 选择器 Selector SelectableChannel 多路复用器 用于监控通道的IO状况 
 * @author liuxun
 *
 */
public class TestNonBlockingNIO {

	
	//客户端
    @Test
    public void client() throws IOException{
    	//1.建立客户端
    	SocketChannel client = SocketChannel.open(new InetSocketAddress("127.0.0.1",9999));
    	//2.切换非阻塞模式
    	client.configureBlocking(false);
    	//3. 分配缓冲区
    	ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
    	//4.写入数据到缓冲区 
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
    //服务端
    @Test
    public void server() throws IOException{
      //1. 建立服务端
      ServerSocketChannel serverSocketChannel = ServerSocketChannel.open().bind(new InetSocketAddress(9999));
      //2. 切换非阻塞模式
      serverSocketChannel.configureBlocking(false);
      //3. 获取选择器
      Selector selector = Selector.open();
      //4. 将通道与选择器绑定 
      serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
      //5.轮询式的获取已经准备就绪的状态
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
