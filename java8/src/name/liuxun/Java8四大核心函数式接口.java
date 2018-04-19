package name.liuxun;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

/**
 * 
 * @author liuxun
 * 
 * 1 public interface Consumer<T> 消费型接口
 *    void accept(T t);
 *  
 * 2.public interface Supplier<T> 供给形接口
 *    T get();              
 * 
 * 3.public interface Function<T, R> 函数形接口
 *    R apply(T t); 
 * 
 * 4.public interface Predicate<T>  断言形接口    
 *    boolean test(T t);    
 *  
 *  
 *  
 *  
 */
public class Java8四大核心函数式接口 {

	@Test
	public void test1(){
	  happy(50L, (d) -> System.out.println("今天我consumer 了 ;"+d));	
	}
	@Test
	public void test2(){
		int i = suport(() -> 10);
		System.out.println(i);
	}
	@Test
	public void test3(){
		int i = 10 ;
		int d =0 ;
		d = function(i, (Integer x) -> x);
	}
	@Test
	public void test4(){
		int i =8;
		if(Predicate1(i, (x) -> x%2 ==0)){
			System.out.println("oushu");
		}
	}
	
	public void happy(double money,Consumer<Double> consumer){
		consumer.accept(money);
	}
	public int suport(Supplier<Integer> sup){
		return sup.get();
	}
	public Integer function(Integer t,Function<Integer,Integer> fun){
		return fun.apply(t);
	}
	public boolean Predicate1(Integer i,Predicate<Integer> pre){
		return pre.test(i);
	}
}
