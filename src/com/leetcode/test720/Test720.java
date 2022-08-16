package com.leetcode.test720;

import java.util.HashSet;
import java.util.Set;

/**
 * 2022/5/16 21:20
 *
 * @author chris
 * @version 1.0
 */
public class Test720 {
    public static void main(String[] args) {
        String[] words = {"w", "wo", "wor", "worl", "world"};
        Solution solution = new Solution();
        System.out.println(solution.longestWord(words));
    }
}


class Solution {
    public String longestWord(String[] words) {
        String ans = "";
        Set<String> set = new HashSet<>();
        for (String s : words) {
            set.add(s);
        }
        for (String s : set) {
            int n = s.length(), m = ans.length();
            if (n < m) {
                continue;
            }
            if (n == m && s.compareTo(ans) > 0) {
                continue;
            }
            boolean ok = true;
            for (int i = 1; i <= n && ok; i++) {
                String sub = s.substring(0, i);
                if (!set.contains(sub)) {
                    ok = false;
                }
            }
            if (ok) {
                ans = s;
            }
        }
        return ans;
    }
}
