package com.hazer;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 * @description: http://vod.anychat.cn/9716CE33-0BAF-41C2-B256-D34E315BFD9A/record/2020-06-17/0042BD1A-F388-46A2-83C6-F0B089601BA6/2020-06-17-15-39-48-1664_bairuiAgent.mp4?auth_key=1624158070-0-0-d2b1313b1bfe05b16a6fa5e6ba876119&time_stamp=1624158070000&sign=3db39f7201f51004a82276520743c886
 * @author: Hazer
 * @date: 2020-06-20 10:16
 */
public class NioTest {
    public void downloadTest() {
        String path = "http://vod.anychat.cn/9716CE33-0BAF-41C2-B256-D34E315BFD9A/record/2020-06-17/0042BD1A-F388-46A2-83C6-F0B089601BA6/2020-06-17-15-39-48-1664_bairuiAgent.mp4?auth_key=1624158070-0-0-d2b1313b1bfe05b16a6fa5e6ba876119&time_stamp=1624158070000&sign=3db39f7201f51004a82276520743c886";


        try (InputStream inputStream = new URL(path).openStream();
             ReadableByteChannel readableByteChannel = Channels.newChannel(inputStream)) {
             
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
