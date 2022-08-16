package com.leetcode.test392;

/**
 * 2022/4/21 8:21
 *
 * @author chris
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        Solution solution = new Solution();
        System.out.println(solution.isSubsequence(s, t));
    }
}

class Solution {
    public boolean isSubsequence(String s, String t) {
        int n1 = s.length(), n2 = t.length();
        int index1 = 0, index2 = 0;
        if (n1 == 0) {
            return true;
        }
        while (index1 < n1 && index2 < n2) {
            if (s.charAt(index1) == t.charAt(index2)) {
                index1++;
                index2++;
                continue;
            }
            index2++;
        }
        return index1 == n1;
    }
}
