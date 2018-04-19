package name.liuxun;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

import org.junit.Test;

public class TestPipe {

	@Test
	public void test() throws IOException{
		
		Pipe pipe = Pipe.open();
		
		ByteBuffer buf = ByteBuffer.allocate(1024);
		buf.put("diu ni mei".getBytes());
		buf.flip();
		Pipe.SinkChannel sink = pipe.sink();
		
		sink.write(buf);
		buf.flip();
		
		Pipe.SourceChannel source = pipe.source();
		int len = source.read(buf);
		
		System.out.println(new String(buf.array(),0,len));
		buf.clear();
	}
	
}
