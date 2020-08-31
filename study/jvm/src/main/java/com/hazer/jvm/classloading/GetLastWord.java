package com.hazer.jvm.classloading;

import java.util.Scanner;

/**
 * 获取輸入的最后一个单词
 * @author Hazer
 * @date 2020-08-28 18:39
 */
public class GetLastWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()){
            String[] s =scanner.nextLine().split(" ");
            System.out.println(s[s.length-1].length());
        }


    }

}
