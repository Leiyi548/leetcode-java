package com.neoleetcode.test01;

public class Test {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        Solution solution = new Solution();
        System.out.println(solution.massage(nums));
    }
}

class Solution {

    public int massage(int[] nums) {
        // get array length
        int len = nums.length;
        // special case
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }

        // dp[i][0]：区间 [0, i] 里接受预约请求，并且下标为 i 的这一天不接受预约的最大时长
        // dp[i][1]：区间 [0, i] 里接受预约请求，并且下标为 i 的这一天接受预约的最大时长
        int[][] dp = new int[len][2];
        // initialization
        dp[0][0] = 0;
        dp[0][1] = nums[0];

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }
}
