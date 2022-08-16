package com.leetcode.test189;

import java.util.Arrays;

/**
 * 2022/5/11 11:01
 *
 * @author chris
 * @version 1.0
 */
public class Test189 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        Solution solution = new Solution();
        solution.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}

class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }

}


