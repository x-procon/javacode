package com.hazer.io;

import org.junit.Test;

import java.io.*;

/**
 * @description: </br>
 * @author: Hazer
 * @date: 2020-06-19 10:29
 */
public class CopyFile {
    public static void main(String[] args) {
        long timeStamp = System.currentTimeMillis();
        System.out.println(timeStamp);
    }


    public void test1(){
        copyFileWithNoBuffer("6caa45ec-ec2e-47a8-887f-a878e7a90d1f.mp4","test.mp4");
        copyFileWithNoBuffer("6caa45ec-ec2e-47a8-887f-a878e7a90d1f.mp4","test2.mp4");
    }

    public void copyFileWithNoBuffer(String src, String dest){
        // 1.获取流
        //读取视频文件
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            long startTime = System.currentTimeMillis();
            File file = new File(src);
            fis = new FileInputStream(file);
            fos = new FileOutputStream(dest);
            byte[] buff = new byte[1024];
            int data;
            while((data = fis.read(buff)) != -1){
                fos.write(buff,0,data);
            }
            long endTime = System.currentTimeMillis();
            long spendTime = endTime - startTime;
            System.out.println("复制花费的时间"+spendTime);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }








    public void copyFileWithBuffer(String src, String dest){
        // 1.获取流
        //读取视频文件
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            long startTime = System.currentTimeMillis();
            File file = new File(src);

            bis = new BufferedInputStream(new FileInputStream(file));
            bos = new BufferedOutputStream(new FileOutputStream(dest));
            byte[] buff = new byte[1024];
            int data;
            while((data = bis.read(buff)) != -1){
                bos.write(buff,0,data);
            }
            long endTime = System.currentTimeMillis();
            long spendTime = endTime - startTime;
            System.out.println("复制花费的时间"+spendTime);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
