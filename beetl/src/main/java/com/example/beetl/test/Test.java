package com.example.beetl.test;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.StringTemplateResourceLoader;

import java.io.IOException;

/**
 * Created with liuxun
 * Description:
 * Date: 2018-05-02-14:49
 */
public class Test {
    public  static void main(String[] args) throws IOException {
        StringTemplateResourceLoader resourceLoader = new
                StringTemplateResourceLoader();
        Configuration cfg = Configuration.defaultConfiguration();
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
        Template t = gt.getTemplate("hello,${name}");
        t.binding("name", "beetl");
        String str = t.render();
        System.out.println(str);
    }
}
