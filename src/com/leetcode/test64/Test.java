package com.leetcode.test64;

/**
 * @author Leiyi548
 * @package com.力扣.test64
 * @project leetcode
 * @created 2022/3/10 10:03 周四
 */
public class Test {
    public static void main(String[] args) {
//        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int[][] grid = {{1, 2, 3}, {4, 5, 6}};
        int res = new Solution().minPathSum(grid);
        System.out.println(res);
    }

    public static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf(arr[i][j] + " ");
            }
        }
        System.out.println();
    }

}

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // dp[i][j]表示到达这个位置的最小路径和
        int dp[][] = new int[m][n];
        // 初始化最原始的点
        dp[0][0] = grid[0][0];
        // 初始化列
        for (int i = 1; i < m; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][0] += grid[j][0];
            }
        }
        // 初始化行
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[0][i] += grid[0][j];
            }
        }

        // 动态规划
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + grid[i][j], dp[i][j - 1] + grid[i][j]);
            }
        }
        return dp[m - 1][n - 1];
    }
}
