package com.hazer.jsoup;

import com.hazer.entity.Content;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hazer
 * @since  2020-07-20 15:34
 */
public class JsoupUtil {
    private JsoupUtil() {
    }

    private static final Logger LOG = LoggerFactory.getLogger(JsoupUtil.class);
    public static List<Content> parseJd(String keyword) throws IOException {
        String url = "https://search.jd.com/Search?enc=utf-8&keyword=" + keyword;
        Document document = Jsoup.connect(url).get();
        Element element = document.getElementById("J_goodsList");
        Assert.notNull(element,"element不能为空");
        Elements elements = element.getElementsByTag("li");
        List<Content> contents = new ArrayList<>();
        for (Element el : elements) {
            String price = el.getElementsByClass("p-price").eq(0).text();
            String name = el.getElementsByClass("p-name").eq(0).text();
            String img = el.getElementsByTag("img").eq(0).attr("src");
            Content content = new Content(img, name, price);
            LOG.info(String.valueOf(content));
            contents.add(content);
        }
        return contents;
    }
}
