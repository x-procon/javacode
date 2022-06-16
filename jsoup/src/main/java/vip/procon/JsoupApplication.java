package vip.procon;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>爬虫测试</p>
 *
 * @author Procon
 * @since 2022/6/16
 */
public class JsoupApplication {

    public static void main(String[] args) throws Exception {

        String domain = "https://javdb36.com";
        String categoryUrl = "/tags/uncensored?c10=1%2C2";
        List<String> movieUrlList = getMovieUrlList(17, domain, categoryUrl, "uncensored中文鏈接.txt");
        getMagnetList(movieUrlList, "javdb無碼中文磁力.txt");


    }

    public static List<String> getMagnetList(List<String> movieList, String fileName) throws Exception {
        List<String> magnetList = new ArrayList<>();
        for (String s : movieList) {
            //爬取磁力鏈接
            Document document = Jsoup.parse(new URL(s), 10000);
            Elements magnetEleList = document.getElementsByClass("magnet-name column is-four-fifths");
            Element element = magnetEleList.get(0).child(0);
            String magnet = element.attr("href");
            System.out.println(magnet);
            magnetList.add(magnet);
        }
        writeToFile(magnetList, fileName);
        return magnetList;
    }

    /**
     * 爬取jav電影列表
     *
     * @param maxPage     最大頁
     * @param domain      域名
     * @param categoryUrl 分類
     * @throws Exception exception
     */
    public static List<String> getMovieUrlList(int maxPage, String domain, String categoryUrl, String fileName) throws Exception {
        List<String> movieUrlList = new ArrayList<>();
        for (int i = 1; i < maxPage; i++) {
            String url = domain + categoryUrl + "&page=" + i;
            Document document = Jsoup.parse(new URL(url), 10000);
            Elements movieList = document.getElementsByClass("movie-list h cols-4 vcols-5");
            Element movieEle = movieList.get(0);
            Elements itemList = movieEle.getElementsByClass("item");
            for (Element e : itemList) {
                Elements boxList = e.getElementsByClass("box");
                Element boxEle = boxList.get(0);
                String movieUrl = boxEle.attr("href");
                System.out.println(movieUrl);
                movieUrlList.add(domain + movieUrl);
            }
        }
        return movieUrlList;

    }


    public static void writeToFile(List<String> fileList, String fileName) {
        File file = new File(fileName);
        BufferedWriter bw = null;
        try {
            if (!file.exists()) {
                boolean newFile = file.createNewFile();
                if (!newFile) {
                    return;
                }
            }
            bw = new BufferedWriter(new FileWriter(file));
            for (String s : fileList) {
                bw.write(s);
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert bw != null;
                bw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
