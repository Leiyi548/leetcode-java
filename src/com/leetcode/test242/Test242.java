package com.leetcode.test242;

import java.util.Arrays;

/**
 * 2022/6/15 15:29
 *
 * @author chris
 * @version 1.0
 */
public class Test242 {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        Solution solution = new Solution();
        System.out.println(solution.isAnagram(s, t));
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {

        // covert to a character array
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        int n1 = s.length();
        int n2 = t.length();
        if (n1 != n2) {
            return false;
        } else {
            for (int i = 0; i < n1; i++) {
                if (sArr[i] != tArr[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}

