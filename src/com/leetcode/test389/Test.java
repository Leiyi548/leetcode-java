package com.leetcode.test389;

/**
 * 2022/4/20 8:30
 *
 * @author chris
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
//        String s = "abcd", t = "abcde";
        String s = "", t = "y";
//        Solution solution = new Solution();
//        System.out.println(solution.findTheDifference(s, t));
        Solution02 solution02 = new Solution02();
        System.out.println(solution02.findTheDifference(s, t));
    }
}

class Solution {
    public char findTheDifference(String s, String t) {
        int[] letters = new int[26];
        int n1 = s.length(), n2 = t.length();
        for (int i = 0; i < n1; i++) {
            char ch = s.charAt(i);
            letters[ch - 'a']++;
        }
        for (int i = 0; i < n2; i++) {
            char ch = t.charAt(i);
            if (letters[ch - 'a'] != 0) {
                letters[ch - 'a']--;
            } else {
                return ch;
            }
        }
        return ' ';
    }
}

class Solution02 {
    public char findTheDifference(String s, String t) {
        int intS = 0, intT = 0;
        for (int i = 0; i < s.length(); i++) {
            intS += s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            intT += t.charAt(i);
        }
        return (char) (intT - intS);
    }
}