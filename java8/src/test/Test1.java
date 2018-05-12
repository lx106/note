package test;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created with liuxun
 * Description:
 * Date: 2018-05-09-21:56
 */
public class Test1 {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4};

        //boxed() 装箱操作
        String collect = Arrays.stream(arr).boxed().map(i -> i + "").collect(Collectors.joining(","));
        System.out.println(collect);

        String str2 = Arrays.stream(arr).boxed().map(i -> i + "").reduce(",",String::concat);
        System.out.println(str2);

        String str3 = Arrays.stream(arr).boxed().map(Object::toString).reduce(",",String::concat);
        System.out.println(str3);

    }
}
