package com.leetcode.test121;

/**
 * 2022/4/30 9:43
 *
 * @author chris
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
//        int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices = {3, 2, 6, 5, 0, 3};
//        int[] prices = {7, 6, 4, 3, 1};
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(prices));
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit) {
                    maxprofit = profit;
                }
            }
        }
        return maxprofit;
    }
}
