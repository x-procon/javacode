package com.hazer.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @description: </br>
 * @author: Hazer
 * @date: 2020-07-03 10:03
 */
public class FileChannel01 {
    public static void main(String[] args) {

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(new File("F:\\Coding\\GitHub\\javacode\\study\\netty\\1.txt"));
            fileOutputStream = new FileOutputStream(new File("F:\\Coding\\GitHub\\javacode\\study\\netty\\2.txt"));
            FileChannel fileInputChannel = fileInputStream.getChannel();
            FileChannel fileOutputChannel = fileOutputStream.getChannel();

            //初始化缓冲区
            ByteBuffer byteBuffer = ByteBuffer.allocate(5);

            while ( fileInputChannel.read(byteBuffer) != -1){
                byteBuffer.flip();
                fileOutputChannel.write(byteBuffer);
                byteBuffer.flip();

            }
//            while (true){
//                byteBuffer.clear();
//                if(fileInputChannel.read(byteBuffer) == -1){
//                    break;
//                }
//                byteBuffer.flip();
//                fileOutputChannel.write(byteBuffer);
//            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
