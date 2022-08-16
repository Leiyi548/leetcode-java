package com.leetcode.test405;

/**
 * 2022/6/25 19:49
 *
 * @author chris
 * @version 1.0
 */
public class Test405 {
    public static void main(String[] args) {
        int num = 17;
        // 15二进制是 01111 17 10001
        // 这个就是获得二进制包括15的值
        int temp = num & 15;
        System.out.println(temp);
        // 01
        double test = 1 >>> 4;
        System.out.println(test);
        Solution solution = new Solution();
        System.out.println(solution.toHex(3204));
    }
}

class Solution {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        char[] chars = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder buffer = new StringBuilder();
        int temp;
        while (num != 0) {
            temp = num & 15;
            buffer.insert(0, chars[temp]);
            // 相当于除16
            num >>>= 4;
        }
        return buffer.toString();
    }
}