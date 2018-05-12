package name.liuxun;

/**
 * 计算π
 */
public class TestPI {

	public static void main(String[] args) {
		int n = 1000000000;
		int count =0;
		for (int i = 0; i < n; i++) {
		 double x =	Math.random()*2 - 1; // [-1,1)
	     double y =	Math.random()*2 - 1;
			if(x*x + y*y < 1.0) {
				count++;
			}
		}
		System.out.println(4.0* count/n);
	}
}
