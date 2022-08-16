package com.leetcode.test171;

public class Test {
    public static void main(String[] args) {
        String s = "ZY";
        Solution solution = new Solution();
        System.out.println(solution.titleToNumber(s));
    }
}


class Solution {
    public int titleToNumber(String columnTitle) {
        int ans = 0;
        int n = columnTitle.length();
        int num;
        for (int i = 0; i < n; i++) {
            num = columnTitle.charAt(i) - 'A' + 1;
            ans = ans * 26 + num;
        }
        return ans;
    }

    public int revert(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int num = s.charAt(i) - '0';
            ans = ans * 10 + num;
        }
        return ans;
    }

    private int test(int a, int b, int c) {
        return 0;
    }
}