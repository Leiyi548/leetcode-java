package com.leetcode.test434;

import java.util.Objects;

/**
 * 2022/4/24 10:35
 *
 * @author chris
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        String s = ", , , ,        a, eaefa";
        Solution solution = new Solution();
        System.out.println(solution.countSegments(s));
    }
}

class Solution {
    public int countSegments(String s) {
        // 这里的单词指的是连续不是空格的字符
        int segmentCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                segmentCount++;
            }
        }
        return segmentCount;
    }
}