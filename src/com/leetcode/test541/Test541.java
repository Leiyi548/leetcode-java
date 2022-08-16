package com.leetcode.test541;

/**
 * 2022/5/22 10:47
 *
 * @author chris
 * @version 1.0
 */
public class Test541 {
    public static void main(String[] args) {
        String s = "a";
        int k = 2;
        Solution solution = new Solution();
        System.out.println(solution.reverseStr(s, k));
    }
}

class Solution {
    public String reverseStr(String s, int k) {
        char[] cs = s.toCharArray();
        System.out.println(cs);
        int n = s.length();
        System.out.println(n);
        for (int l = 0; l < n; l = l + 2 * k) {
            int r = l + k - 1;
            System.out.println(r);
            reverse(cs, l, Math.min(r, n - 1));
        }
        return String.valueOf(cs);
    }

    public void reverse(char[] cs, int l, int r) {
        while (l < r) {
            char c = cs[l];
            cs[l] = cs[r];
            cs[r] = c;
            l++;
            r--;
        }
    }
}