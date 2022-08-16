package com.leetcode.test151;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author chris
 * @version V1.0
 * @package com.leetcode.test151
 * @date 2022/4/7 9:37
 */

public class Test {
    public static void main(String[] args) {
        String s = "  the   sky is blue   ";
        Solution solution = new Solution();
        System.out.println(solution.reverseWords(s));
    }
}

class Solution {
    public String reverseWords(String s) {
        // 去除前置空格
        s = s.trim();
        int n = s.length();
        String[] stringArray = s.split("\\s+");
        reverseStringArray(stringArray);
        return toString(stringArray);
    }

    private void reverseStringArray(String[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }


    public void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public String toString(String[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i != arr.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
