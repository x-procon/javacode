package com.hazer.huawei;

import java.util.Scanner;

/**
 *
 * 写出一个程序，接受一个由字母和数字组成的字符串，
 * 和一个字符，然后输出输入字符串中含有该字符的个数。
 * 不区分大小写。
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
