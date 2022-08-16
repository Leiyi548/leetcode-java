package com.leetcode.test290;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 2022/4/22 15:58
 *
 * @author chris
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog dog dog dog";
        Solution solution = new Solution();
        System.out.println(solution.wordPattern(pattern, str));
    }
}

class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        String[] arr = s.split(" ");
        int n = pattern.length();
        if (n != arr.length) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            char ch = pattern.charAt(i);
            if (map.containsKey(ch)) {
                if (!Objects.equals(map.get(ch), arr[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(arr[i])) {
                    return false;
                } else {
                    map.put(ch, arr[i]);
                }
            }
        }
        return true;
    }
}