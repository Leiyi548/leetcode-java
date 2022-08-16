package com.leetcode.test191;

/**
 * 2022/5/14 15:52
 *
 * @author chris
 * @version 1.0
 */
public class Test191 {
    public static void main(String[] args) {
        int num1 = 4; // 100
        int num3 = 3; // 011
        int num2 = 1; // 001
        System.out.println(1 << 2);
        System.out.println(num1 & num1);
    }
}

class Solution {
    // you need to treat n as an unsigned value
    // n输入的是2进制的形式
    public int hammingWeight(int n) {
        // 记录结果
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            // 判断32位这个位置对应的那个数字这里有没有1
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        // 返回1的次数
        return ret;
    }
}
