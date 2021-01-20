package com.hazer.io;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @description: </br>
 * @author: Hazer
 * @date: 2020-06-19 14:58
 */
public class FileDownload {

    @Test
    public void download() {
        URL url = null;
        FileOutputStream os = null;
        InputStream inStream = null;
        try {
            url = new URL("http://vod.anychat.cn/9716CE33-0BAF-41C2-B256-D34E315BFD9A/record/2020-06-05/3786A4D6-54EE-4E16-B350-9E0F9BCD8C4D/2020-06-05-17-07-33-1522_sccba.mp4?auth_key=1623722901-0-0-e3b8b4029a43f5ddeea2a4158cd728de&time_stamp=1623722901000&sign=dae39d548f7850046d86014177ca3aa9");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5 * 1000);
            //设置用户代理(防止屏蔽程序抓取而返回403错误)
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

            //通过输入流获取图片数据
            inStream = conn.getInputStream();
            byte[] buffer = new byte[1024];
            int len;
            os = new FileOutputStream("testoss.mp4");
            while ((len = inStream.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                inStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
