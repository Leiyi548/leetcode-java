package com.leetcode.test63;

/**
 * @author Leiyi548
 * @package com.力扣.test63
 * @project leetcode
 * @created 2022/3/9 8:40 周三
 */
public class Test {
    public static void main(String[] args) {
//        int [][]obstacleGrid = { { 0,0,0 },{ 0,1,0 },{ 0,0,0 } };
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(new Solution().uniquePathsWithObstacles(obstacleGrid));
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
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 获得行列
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[][] = new int[m][n];
        // 初始化动态规划
        // 初始化第一列
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] != 1) {
                dp[i][0] = 1;
            } else {
                break;
            }
        }
        // 初始化第一行
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] != 1) {
                dp[0][i] = 1;
            } else {
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}


class Solution02 {
    private int res = 0;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        dfs(0, 0, obstacleGrid, m, n);
        return res;
    }

    public void dfs(int row, int col, int[][] obstacleGrid, int m, int n) {
        // 出口
        if (row > m - 1 || col > n - 1) {
            return;
        }
        if (row == m - 1 && col == n - 1) {
            res++;
            return;
        }
        if (obstacleGrid[row][col] == 1) {
            return;
        }
        //向下走
        dfs(row + 1, col, obstacleGrid, m, n);
        dfs(row, col + 1, obstacleGrid, m, n);
    }
}
