package com.leetcode.test79;
/**
 * @Package com.力扣.test79
 * @author chris
 * @date 2022/3/17 10:23
 * @version V1.0
 */

import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        boolean flag = new Solution02().exist(board, word);
        System.out.println(flag);
    }
}

class Solution {
    /**
     * 先dfs再剪枝
     *
     * @param board 二维字符网格
     * @param word  被搜索的单词
     * @return 单词是否搜索到在二维字符网格。
     */
    public boolean exist(char[][] board, String word) {
        // 获得这个二维数组行列
        int m = board.length;
        int n = board[0].length;
        return false;
    }

    public void dfs(char[][] board, String word, int m, int n, int row, int col, Stack<Character> stack) {
        // 每个网格只能向下或者向右走
        // 判断边界退出
        if (row >= m || col >= n) {
            return;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = board[i][j];
                // 入栈
                stack.push(ch);
                // 向下走
                dfs(board, word, m, n, row + 1, col, stack);
                // 出栈
                stack.pop();
                // 向右走
                dfs(board, word, m, n, row, col + 1, stack);
            }
        }
    }
}


class Solution02 {
    public boolean exist(char[][] board, String word) {
        int h = board.length, w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean flag = check(board, visited, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
        // 如果不在所要的字符串内直接退出这次递归
        if (board[i][j] != s.charAt(k)) {
            return false;
        } else if (k == s.length() - 1) {
            return true;
        }
        // 标记这个点被访问过,因为同一个单元格内的字母不允许被重复使用
        visited[i][j] = true;
        // 用来给数组进行移动 右,左,下,上
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] dir : directions) {
            int newi = i + dir[0], newj = j + dir[1];
            // 判断是否越界
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                // 如果没有被访问过,就继续递归进去.
                if (!visited[newi][newj]) {
                    boolean flag = check(board, visited, newi, newj, s, k + 1);
                    if (flag) {
                        result = true;
                        // 这个方向对了,其他的就没有必要过去了.
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        // 回溯
        return result;
    }
}


class Solution03 {
    /**
     * 方向，分别是 上，下，左，右
     */
    int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public boolean exist(char[][] board, String word) {
        //字符串长度大于 矩阵个数，直接返回
        if (word.length() > board.length * board[0].length) {
            return false;
        }
        //使用记录
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                used[i][j] = true;
                //如果返回的是true,则直接返回，反之则继续
                if (dfs(board, used, i, j, word, 0)) {
                    return true;
                }
                used[i][j] = false;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, boolean[][] used, int h, int l, String word, int index) {
        //字符不相等 返回false
        if (board[h][l] != word.charAt(index)) {
            return false;
        }
        /**
         * 当下标 与 字符串长度 - 1 相等时，返回true.按照逻辑
         * 应该是前面的那个if条件满足后 else 中去判断的，为了
         * 看起来舒服一点(因为自己写的拉跨)
         */

        if (index == word.length() - 1) {
            return true;
        }
        for (int[] a : direction) {
            int row = h + a[0], col = l + a[1];
            // 在矩阵范围内且没有被使用过
            if (row >= 0 && row < board.length && col >= 0 && col < board[0].length && !used[row][col]) {
                used[row][col] = true;
                //如果返回true,则直接返回。反之则继续
                if (dfs(board, used, row, col, word, index + 1)) {
                    return true;
                }
                used[row][col] = false;
            }
        }
        return false;
    }
}