package com.example.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.channels.FileChannel;

public class TestCopy {

    public static void main(String[] args) throws Exception {

        String source = "E:\\soft\\springsource-tool-suite-3.9.0.RELEASE-e4.6.3-updatesite.zip";
        String destination = "E:\\temp\\copy.zip";

        FileChannel in = new FileInputStream(source).getChannel();
        FileChannel out = new FileInputStream(destination).getChannel();

        in.transferTo(0,in.size(),out);
        System.out.println("传输成功");
        //out.transferFrom(in,0,in.size());
    }
}
