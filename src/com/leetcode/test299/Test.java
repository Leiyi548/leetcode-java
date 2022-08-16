package com.leetcode.test299;

/**
 * 2022/4/27 16:34
 *
 * @author chris
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        String secret = "1122", guess = "1222";
        Solution solution = new Solution();
        System.out.println(solution.getHint(secret, guess));
    }
}

class Solution {
    public String getHint(String secret, String guess) {
        StringBuilder sb = new StringBuilder();
        int n = secret.length();
        int countA = 0;
        int countB = 0;
        int[] charCount = new int[128];
        // 先获取secret每个字符的出现次数
        for (int i = 0; i < n; i++) {
            char ch = secret.charAt(i);
            charCount[ch - ' ']++;
        }

        // 先找公牛
        for (int i = 0; i < n; i++) {
            char chSecret = secret.charAt(i);
            char chGuess = guess.charAt(i);
            if (chGuess == chSecret) {
                countA++;
                charCount[chGuess - ' ']--;
            }
        }

        // 再找母牛
        for (int i = 0; i < n; i++) {
            char chSecret = secret.charAt(i);
            char chGuess = guess.charAt(i);
            if (chSecret == chGuess) {
                continue;
            } else {
                if (charCount[chGuess - ' '] > 0) {
                    charCount[chGuess - ' ']--;
                    countB++;
                }
            }
        }

        sb.append(countA);
        sb.append("A");
        sb.append(countB);
        sb.append("B");
        return sb.toString();
    }
}
