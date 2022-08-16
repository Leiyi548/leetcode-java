package com.leetcode.test122;

/**
 * 2022/5/1 10:14
 *
 * @author chris
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 4, 5};
        System.out.println(new Solution().maxProfit(prices));
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int ans = 0;
        // 获取全部递增区间
        // 递增区间最左边的值前面比它大,后面比它大
        // 递增区间最右边的值前面比它小,后面比它小
        for (int i = 1; i < n; i++) {
            ans += Math.max(prices[i] - prices[i - 1], 0);
        }
        return ans;
    }
}
