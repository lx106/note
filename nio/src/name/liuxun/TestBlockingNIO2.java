package name.liuxun;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

import org.junit.Test;

public class TestBlockingNIO2 {

	@Test
	public void client() throws IOException{
		
		SocketChannel sc = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9999));
		
        FileChannel fc = new FileInputStream("2.jpg").getChannel();
        
        ByteBuffer bb = ByteBuffer.allocate(1024);
        
        while(fc.read(bb)!= -1){
        	bb.flip();
        	sc.write(bb);
        	bb.clear();
        }
        sc.shutdownOutput();
        int len = 0 ;
        while((len = sc.read(bb))!= -1){
        	bb.flip();
            System.out.println(new String(bb.array(),0,len));
        	bb.clear();
        }
        
        fc.close();
        sc.close();
	}
	
	@Test
	public void server() throws IOException{
		
		ServerSocketChannel ssc = ServerSocketChannel.open().bind(new InetSocketAddress(9999));
		
		SocketChannel sc = ssc.accept();
		
		FileChannel fc = new FileOutputStream("server.jpg").getChannel();
		
		ByteBuffer bb = ByteBuffer.allocate(1024);
		
		while(sc.read(bb)!= -1){
			bb.flip();
			fc.write(bb);
			bb.clear();
		}
		bb.put("·µ»Øclient".getBytes());
		bb.flip();
		sc.write(bb);
		
		
		fc.close();
		sc.close();
		ssc.close();
	}
}
