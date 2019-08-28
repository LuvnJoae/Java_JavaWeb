package Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupDemo3 {
    public static void main(String[] args) throws IOException {
        String path = Jsoup.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");
        Elements elements = document.getElementsByTag("student");
        System.out.println(elements);
        System.out.println("----------------------------");
        System.out.println("----------------------------");
        Element element = elements.get(0);
        Elements name = element.getElementsByTag("name");
        System.out.println(name);
    }
}
