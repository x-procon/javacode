package com.hazer;

import org.junit.Test;

import java.io.*;

/**
 * @description: </br>
 * @author: Hazer
 * @date: 2020-06-17 19:56
 */
public class FileReaderAndWriteTest {
    @Test
    public void FileReaderTest(){
        File file = new File("src\\main\\resources\\hello.txt");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            int data;
            while ((data=fileReader.read()) != -1 ){
                System.out.print((char)(data));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }



    @Test
    public void FileWriterTest(){
        File file = new File("writeTest.txt");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("好想大力日B！JB好硬");
            char[] chars = stringBuilder.toString().toCharArray();
            fileWriter.write(chars);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(fileWriter != null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
