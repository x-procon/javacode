package com.huangpuguang;

/**
 * <p>Solution</p>
 *
 * @author Procon
 * @since 2021/11/22
 */
public class Solution {
    public static int fib(int n) {
        if(n <= 1){
            return n;
        }
        int[] fib = new int[n+1];
        fib[0] = 0;
        fib[1] = 1;
        for(int i = 2; i < fib.length; i++){
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n];
    }

    public static void main(String[] args) {
        int fib = Solution.fib(10);
        System.out.println(fib);
    }
}
