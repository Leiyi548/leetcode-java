package com.leetcode.test162;

/**
 * 2022/5/4 9:56
 *
 * @author chris
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution solution = new Solution();
        System.out.println(solution.findPeakElement(nums));
    }
}

class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 2;
        // 特殊情况判断
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return nums[0] > nums[1] ? 0 : 1;
        }
        while (right < n) {
            if (nums[left + 1] > nums[right] && nums[left + 1] > nums[left]) {
                return left + 1;
            }
            left++;
            right++;
        }
        if (nums[left + 1] > nums[left]) {
            return left + 1;
        }
        return 0;
    }
}
