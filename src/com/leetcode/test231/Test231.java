package com.leetcode.test231;

/**
 * 2022/6/10 12:49
 *
 * @author chris
 * @version 1.0
 */
public class Test231 {
    public static void main(String[] args) {
        int n = 16;
        Solution solution = new Solution();
        System.out.println(solution.isPowerOfTwo(n));
    }
}

class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        while (n % 2 == 0) {
            n = n / 2;
        }

        if (n == 1) {
            return true;
        } else {
            return false;
        }
    }
}
