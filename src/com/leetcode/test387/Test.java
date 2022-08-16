package com.leetcode.test387;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 2022/4/19 9:41
 *
 * @author chris
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        String s = "loveleetcode";
//        Solution solution = new Solution();
//        System.out.println("solution.firstUniqChar(s) = " + solution.firstUniqChar(s));
        Solution02 solution = new Solution02();
        System.out.println("Solution02.firstUniqChar(s) = " + solution.firstUniqChar(s));
    }

}

class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}

class Solution02 {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, -1);
            } else {
                map.put(ch, i);
            }
        }
        int ans = n;
        Set keySet = map.keySet();
        for (Object key : keySet) {
            if (map.get(key) != -1 && map.get(key) < ans) {
                ans = map.get(key);
            }
        }
        if (ans == n) {
            return -1;
        }
        return ans;
    }
}