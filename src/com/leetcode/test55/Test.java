package com.leetcode.test55;

/**
 * @author Leiyi548
 * @date 2022/2/26 11:11
 */
public class Test {
    public static void main(String[] args) {
//        int[] nums = {2, 3, 1, 1, 4};
        int[] nums = {3, 2, 1, 0, 4};
        Solution solution = new Solution();
        System.out.println(solution.canJump(nums));
    }
}

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        // 所能到达的最远距离
        int reach = 0;
        for (int i = 0; i < n; i++) {
            if (reach < i) return false;
            reach = Math.max(i + nums[i], reach);
        }
        return true;
    }
}
