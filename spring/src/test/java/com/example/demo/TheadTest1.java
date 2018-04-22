package com.example.demo;

public class TheadTest1 {

    private int number;

    public void add() {
        number++;
    }

    public static void main(String[] args) {
        TheadTest1 demo = new TheadTest1();
        System.out.println(demo.number);
        for (int i = 0; i < 500; i++) {

            /*new Thread(new Runnable() {
                @Override
                public void run() {
                    demo.add();
                }
            }).start();*/
        }
        while( Thread.activeCount() >1 ){
            Thread.yield();
        }
        System.out.println(demo.number);

    }
}
