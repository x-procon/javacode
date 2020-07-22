package com.hazer.jsoup;

import com.hazer.entity.Content;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: </br>
 * @author: Hazer
 * @date: 2020-07-20 15:34
 */
public class JsoupUtil {
    public static List<Content> parseJD(String keyword) throws IOException {
        String url = "https://search.jd.com/Search?enc=utf-8&keyword="+keyword;
        Document document = Jsoup.connect(url).get();
        Element element = document.getElementById("J_goodsList");
        Elements elements = element.getElementsByTag("li");
        List<Content> contents = new ArrayList<>();
        for(Element el: elements){
            String price = el.getElementsByClass("p-price").eq(0).text();
            String name = el.getElementsByClass("p-name").eq(0).text();
            String img = el.getElementsByTag("img").eq(0).attr("src");
            Content content = new Content(img,name,price);
            System.out.println(content);
            contents.add(content);
        }
        return contents;
    }
}
