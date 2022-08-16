package com.leetcode.test205;

import java.util.HashMap;

/**
 * hflkjlk
 * fsdjlkfjsl
 */
public class Test {
    public static void main(String[] args) {
        String s = "badc";
        String t = "baba";
        Solution solution = new Solution();
        System.out.println(solution.isIsomorphic(s, t));
    }
}

class Solution {
    public boolean isIsomorphic(String s, String t) {
        return isIsomorphicHelper(s, t) && isIsomorphicHelper(t, s);
    }

    private boolean isIsomorphicHelper(String s, String t) {
        int n = s.length();
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            // 获得两个字符串的字符
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            // 如果已经有这个字符(前面已经出现)
            if (map.containsKey(c1)) {
                // 验证之前的映射和当前的字母是否相同。
                if (map.get(c1) != c2) {
                    return false;
                }
            } else {
                // 加入映射关系
                map.put(c1, c2);
            }
        }
        return true;
    }
}

class Solution02 {

    public boolean isIsomorphic(String s, String t) {
        return isIsomorphicHelper(s).equals(isIsomorphicHelper(t));
    }

    private String isIsomorphicHelper(String s) {
        int[] map = new int[128];
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (map[c] == 0) {
                map[c] = count;
                count++;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}