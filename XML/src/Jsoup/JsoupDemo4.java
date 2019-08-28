package Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupDemo4 {
    public static void main(String[] args) throws IOException {
        /**
         * 查询方法与规则都在Jsoup自带的index说明文档中
         * 基本上是按照CSS选择器的规则
         */

        //1. 获取path
        String path = Jsoup.class.getClassLoader().getResource("student.xml").getPath();
        //2. 获取Dom对象
        Document document = Jsoup.parse(new File(path), "utf-8");

        //3. 查询 name 标签
        Elements name = document.select("name");
        System.out.println(name);

        System.out.println("---------------");

        //4. 查询 id 为itcast的元素
        Elements itcast = document.select("#itcast");
        System.out.println(itcast);

        System.out.println("---------------");

        //5. 获取 student 标签 并且 number 属性值为heima_0001的age子标签
            //5.1. 获取student标签并且number属性值为heima_0001
        Elements select = document.select("student[number='heima_0001']");
        System.out.println(select);

        System.out.println("---------------");
            //5.2. 获取 student 标签 并且 number 属性值为heima_0001的age子标签
        Elements select2 = document.select("student[number='heima_0001'] > age");
        System.out.println(select2);

    }
}
