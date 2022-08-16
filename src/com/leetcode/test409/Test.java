package com.leetcode.test409;

/**
 * 2022/4/15 15:36
 *
 * @author chris
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        String s = "abcccdd";
        Solution solution = new Solution();
        int num = 1;
        System.out.println(solution.longestPalindrome(s));
    }
}

class Solution {
    public int longestPalindrome(String s) {
        // 因为这个回文字符串只包含 大写字母和小写字母
        int[] count = new int[128];
        int length = s.length();
        // 获得字符串每个不同的字符出现的次数
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            count[ch]++;
        }
        int ans = 0;
        for (int v : count) {
            // 得到的ans一定是偶数
            ans += v / 2 * 2;
            // 因为一个回文字符串只能有一个奇数字符串次数出现将它放在中间
            // 那么它一定是个长度为奇数的字符串,ans % 2 == 0 代表以前的都为偶数次数出现
            if (v % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }
}