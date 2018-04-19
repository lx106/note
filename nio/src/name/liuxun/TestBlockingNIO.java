package name.liuxun;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

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
public class TestBlockingNIO {

	@Test //客户端
	public void client() throws IOException{
	  SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",9898));
	 ByteBuffer bb = ByteBuffer.allocate(1024);
	 bb.put("深圳大本营".getBytes());
	 bb.flip();
	 socketChannel.write(bb);
	 socketChannel.close();
	  
	}
	
	@Test //服务端
	public void server() throws IOException{
		
	  ServerSocketChannel serverSocketChannel = ServerSocketChannel.open().bind(new InetSocketAddress(9898));	
	  SocketChannel client = serverSocketChannel.accept();
	  
	  ByteBuffer bb = ByteBuffer.allocate(1024);
	  client.read(bb);
	  System.out.println(bb.position());
	  bb.flip();
	  System.out.println(bb.position());
	  byte[] buf = new byte[1024];
	  
	  bb.get(buf, 0, bb.limit());
	  System.out.println(bb.limit());
	  
	  System.out.println("sfdsdfa");
	  client.close();
	  serverSocketChannel.close();
	  
	  
	}
}
