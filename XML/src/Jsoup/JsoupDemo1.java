package Jsoup;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class JsoupDemo1 {
    public static void main(String[] args) throws IOException {
        //2. 获取Document对象,根据xml文档获取
            //2.1. 获取student.xml的path
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
            //2.2. 解析xml文档，加载文档进内存，获取dom树 ----> Document
        Document document = Jsoup.parse(new File(path), "utf-8");
        //3. 获取元素对象 Element  (这里获得的是一个泛型为Element的ArrayList，Elements就是ArrayList<Element>的一个子类)
        Elements elements = document.getElementsByTag("name");
            //3.1. 获取第一个标签为name的Element (获得方法和ArrayList的方法一样)
        Element element1 = elements.get(0);
            //3.2. 获得该Element的数据。
        String text = element1.text();//该方法是获得其中的文本内容。

        System.out.println(text);
    }
}
