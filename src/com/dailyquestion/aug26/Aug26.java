package com.dailyquestion.aug26;

import java.util.Arrays;

public class Aug26 {
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 2};
        Solution solution = new Solution();
        System.out.println(solution.maxProduct(nums));
    }
}

class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        return (nums[len - 1] - 1) * (nums[len - 2] - 1);
    }
}
