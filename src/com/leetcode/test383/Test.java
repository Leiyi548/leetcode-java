package com.leetcode.test383;

/**
 * 2022/4/18 15:00
 *
 * @author chris
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        String randsomNote = "aa";
        String magazine = "abb";
        Solution solution = new Solution();
        System.out.println(solution.canConstruct(randsomNote, magazine));
    }
}

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int n1 = ransomNote.length(), n2 = magazine.length();
        if (n1 == n2 && ransomNote.equals(magazine)) {
            return true;
        }
        if (n1 > n2) {
            return false;
        }
        int[] word = new int[26];
        // 记录magazine每个单词的出现次数
        for (int i = 0; i < n2; i++) {
            char ch = magazine.charAt(i);
            word[ch - 'a']++;
        }
        for (int i = 0; i < n1; i++) {
            char ch = ransomNote.charAt(i);
            if (--word[ch - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
