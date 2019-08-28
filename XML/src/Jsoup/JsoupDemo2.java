package Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class JsoupDemo2 {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://wlan.jsyd139.com/?wlanuserip=172.30.4.74&wlanacname=0011.0519.250.00&ssid=CMCC-EDU");
        Document document = Jsoup.parse(url, 10000);
        System.out.println(document);
    }
}
