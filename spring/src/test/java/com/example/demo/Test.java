package com.example.demo;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args){
        int[] arr = new int[64*1024*1024];

// Loop 1
/*        Instant instant1 =  Instant.now();
        for (int i = 0; i < arr.length; i++) arr[i] *= 3;
        Instant instant2 =  Instant.now();
        System.out.println(Duration.between(instant1,instant2).toNanos());

// Loop 2
        Instant instant3 =  Instant.now();
        for (int i = 0; i < arr.length; i += 2) arr[i] *= 3;
        Instant instant4 =  Instant.now();
        System.out.println(Duration.between(instant3,instant4).toNanos());*/


        //int steps = 64 * 1024 * 1024; //67108864 * 4B  = 268435456
        // 8bit = 1B      int = 4B
        // 1024B = 1KB    32KB
        // int[4] =       4 * 4B = 16B  256KB = 256*1024 = 262144
        // 4M = 4 * 1024 * 1024
        // 一个cache line = 64 字节
        // 字节 = Byte  1B
        // Arbitrary number of steps
        /*int lengthMod = arr.length - 1;
        Instant instant1 =  Instant.now();
        for (int i = 0; i < steps; i++)
        {
            arr[(i * 16) & lengthMod]++; // (x & lengthMod) is equal to (x % arr.Length)86000000 570000000
        }
        Instant instant2 =  Instant.now();
        System.out.println(Duration.between(instant1,instant2).toNanos());*/


        /*int steps = 256 * 1024 * 1024;
        int[] a = new int[2];

// Loop 1
        Instant instant1 =  Instant.now();
        for (int i=0; i<steps; i++) { a[0]++; a[0]++; }
        Instant instant2 =  Instant.now();
        System.out.println(Duration.between(instant1,instant2).toNanos());

// Loop 2
        int[] b = new int[2];
        Instant instant3 =  Instant.now();
        for (int i=0; i<steps; i++) { b[0]++; b[1]++; }
        Instant instant4 =  Instant.now();
        System.out.println(Duration.between(instant3,instant4).toNanos());*/

        User user = new User();
        String s = "";
        for (int i = 0; i < 3; i++) {
            s += user.getStatus();
        }
        System.out.println(s);

    }

}


