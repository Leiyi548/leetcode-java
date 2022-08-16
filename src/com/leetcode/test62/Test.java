package com.leetcode.test62;

import java.util.Scanner;

/**
 * @author Leiyi548
 * @package com.力扣.test62
 * @project leetcode
 * @created 2022/3/8 20:38 周二
 */
public class Test {
    public static void main(String[] args) {
        int m, n;
        System.out.println("Please input m(int) n(int)");
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        System.out.println(new Solution02().uniquePaths(m, n));
    }
}

// 递归解法
class Solution {
    private int res = 0;

    public int uniquePaths(int m, int n) {
        // 画出棋盘
        int[][] board = new int[m][n];
        dfs(board, 0, 0, m, n);
        return res;
    }

    public void dfs(int[][] board, int row, int col, int m, int n) {
        // 出口
        // 超出边界,退出
        if (row > m - 1 || col > n - 1) {
            return;
        }
        if (row == m - 1 && col == n - 1) {
            res++;
            return;
        }
        // 入口,递归
        // 向下走
        dfs(board, row + 1, col, m, n);
        // 向右走
        dfs(board, row, col + 1, m, n);
    }
}

// 动态规划
class Solution02 {
    public int uniquePaths(int m, int n) {
        // dp[i][j]表示能有几条不同的路径到达这个位置
        int[][] dp = new int[m][n];
        // 第一行每个格子都是1
        for (int i = 1; i < n; i++) {
            dp[0][i] = 1;
        }
        // 第一列每个格子都是1
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;

        }
        // 动态规划的推导公式
        // dp[i][j] = dp[i-1][j] + dp[i][j-1];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

}