package com.leetcode.test268;

/**
 * 2022/5/9 10:24
 *
 * @author chris
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        Solution solution = new Solution();
        System.out.println(solution.missingNumber(nums));
    }
}

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        boolean[] flag = new boolean[n + 1];
        for (int num : nums) {
            flag[num] = true;
        }
        for (int i = 0; i < n + 1; i++) {
            if (!flag[i]) {
                return i;
            }
        }
        return -1;
    }
}
