package com.hazer.huawei;

import java.util.Scanner;

/**
 * 写出一个程序，接受一个由字母和数字组成的字符串，
 * 和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
 *
 * @author Hazer
 * @date 2020-08-28 19:04
 */
public class GetCharNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine().toLowerCase();
            Scanner scanner2 = new Scanner(System.in);
            while (scanner2.hasNextLine()) {
                String s1 = scanner2.nextLine().toLowerCase();
                String[] split = s.split(s1);
                System.out.println(split.length - 1);
                break;
            }
        }
    }

}
