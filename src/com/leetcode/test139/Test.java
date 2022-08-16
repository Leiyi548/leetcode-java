package com.leetcode.test139;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author chris
 * @version V1.0
 * @package com.leetcode.test139
 * @date 2022/4/5 10:22
 */

public class Test {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        Solution02 solution02 = new Solution02();
        System.out.println(solution02.wordBreak(s, list));
    }
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
        for (int i = 0; i < length; i++) {
            if (!dp[i]) {
                continue;
            }
            for (String word : wordDict) {
                if (word.length() + i <= s.length() && s.startsWith(word, i)) {
                    dp[i + word.length()] = true;
                }
            }
        }
        return dp[length];
    }
}

class Solution02 {
    public boolean wordBreak(String s, List<String> wordDict) {
        TrieNode root = new TrieNode('/');
        for (String word : wordDict) {
            TrieNode tmp = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (tmp.children[index] == null) {
                    tmp.children[index] = new TrieNode(c);
                }
                tmp = tmp.children[index];
            }
            tmp.isEndingChar = true;
        }

        int index = 0;
        TrieNode p = root;
        while (index < s.length()) {
            p = root;
            while (true) {
                int i = s.charAt(index) - 'a';
                if (p.children[i] == null) {
                    return false;
                }
                p = p.children[i];
                index++;
                if (p.isEndingChar) {
                    break;
                }
                if (index == s.length()) {
                    return false;
                }
            }
        }
        return true;
    }

    class TrieNode {
        public char data;
        public TrieNode[] children = new TrieNode[26]; // 使用数组保存结果
        public boolean isEndingChar = false;

        public TrieNode(char data) {
            this.data = data;
        }
    }
}

class Solution03 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}