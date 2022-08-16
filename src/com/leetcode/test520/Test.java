package com.leetcode.test520;

/**
 * 2022/4/25 8:29
 *
 * @author chris
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        String word = "hello,World";
        Solution solution = new Solution();
        System.out.println(solution.detectCapitalUse(word));
    }
}

class Solution {
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        int index = 1;
        // 1.全部都是大写字母
        if (word.toUpperCase().equals(word)) {
            return true;
        }
        if (word.toLowerCase().equals(word)) {
            return true;
        }
        // 如果首字母是大写字母
        if (Character.isUpperCase(word.charAt(0))) {
            while (index < n && Character.isLowerCase(word.charAt(index))) {
                index++;
            }
        }
        return index == n;
    }
}
