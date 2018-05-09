package test;

public class TestDump {
	
	public static void main(String[] args) {
		byte[][] bytes = new byte[1*1024*1024][10];
		
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = new byte[1*1024*1024];
		}
	}

}
