package name.liuxun1;


/**
 *  java8 支持多个相同注解
 */
public class TestAnnotation {

	@MyAnnotation("hello")
	@MyAnnotation("world")
	public void test(){
		
	}
	
	public void test1(@MyAnnotation("xun")String str){
		
	}
	
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		Class<TestAnnotation> clz =	TestAnnotation.class;
		 
		 MyAnnotation[] ano= clz.getMethod("test").getAnnotationsByType(MyAnnotation.class);
		 
		for (MyAnnotation myAnnotation : ano) {
			System.out.println(myAnnotation.value());
		}
		System.out.println(ano);
		
	}
}
