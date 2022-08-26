package com.neoleetcode.test02;

import org.jetbrains.annotations.NotNull;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums = {3, 0, 1};
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(solution.missingNumber(nums));
    }
}

class Solution {
    public int missingNumber(int @NotNull [] nums) {
        //  使用求总和然后来减获答案
        // 其实求的就是(1~len)的总和
        int len = nums.length;
        // 1~n的总和
        int sum = len * (1 + len) / 2;
        System.out.println(sum);
        for (int i = 0; i < len; i++) {
            sum -= nums[i];
        }
        return sum;
    }
}
