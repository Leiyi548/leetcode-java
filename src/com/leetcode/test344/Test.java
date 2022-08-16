package com.leetcode.test344;

import java.util.Arrays;

/**
 * 2022/4/16 15:53
 *
 * @author chris
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        char[] arr = {'h', 'e', 'l', 'l', '0'};
        Solution solution = new Solution();
        solution.reverseString(arr);
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }
}

class Solution {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            swap(s, left, right);
            left++;
            right--;
        }
    }

    public void swap(char[] s, int i, int j) {
        char ch = s[i];
        s[i] = s[j];
        s[j] = ch;
    }
}