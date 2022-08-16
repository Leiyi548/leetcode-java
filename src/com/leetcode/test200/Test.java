package com.leetcode.test200;

/**
 * 2022/5/5 10:06
 *
 * @author chris
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        Solution solution = new Solution();
        System.out.println(solution.numIslands(grid));
    }
}


class Solution {
    //利用深度递归解决，可以看图，并加记住这个模板，他可以解决岛屿中的问题，还有一题岛屿面积问题也是这个模板。
    public int numIslands(char[][] grid) {
        //定义一个表示岛屿数量的变量
        int count = 0;
        //这个两层for循环是用来遍历整张二维表格中所有的陆地
        //其中 i 表示行，j 表示列
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //取出所有的陆地
                if (grid[i][j] == '1') {
                    //深度递归，遍历所有的陆地
                    dfs(grid, i, j);
                    //用来统计有多少岛屿，岛屿是由多个陆地组成的，概念不一样
                    count++;
                }
            }
        }
        //返回岛屿的数量
        return count;
    }

    public void dfs(char[][] grid, int i, int j) {
        //防止 i 和 j 越界，也就是防止超出岛屿（上下左右）的范围。特别注意当遍历到海洋的时候也退出循环
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        //将遍历过的陆地改为海洋，防止重复遍历
        grid[i][j] = '0';
        //向下遍历
        dfs(grid, i + 1, j);
        //向上遍历
        dfs(grid, i - 1, j);
        //向右遍历
        dfs(grid, i, j + 1);
        //向左遍历
        dfs(grid, i, j - 1);
    }
}
