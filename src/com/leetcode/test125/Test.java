package com.leetcode.test125;

import java.util.Locale;

/**
 * @author chris
 * @version V1.0
 * @package com.leetcode.test125
 * @date 2022/4/1 16:17
 */

public class Test {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        Solution02 solution = new Solution02();
        System.out.println(solution.isPalindrome(s));
    }
}

class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "");
        s = s.toLowerCase();
        int n = s.length();
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            right--;
            left++;
        }
        return true;
    }
}

class Solution02 {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0;
        int right = n - 1;
        s = s.toLowerCase();
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}