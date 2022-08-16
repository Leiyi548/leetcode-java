package com.leetcode.test58;

/**
 * @author Leiyi548
 * @package com.力扣.test58
 * @project leetcode
 * @created 2022/3/6 9:40 周日
 */
public class Test {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
        printArr(new Solution().generateMatrix(3));
    }

    public static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}


class Solution {

    public int[][] generateMatrix(int n) {
        // 创建存放答案的空间
        int[][] newGenerateMatrix = new int[n][n];
        // 定义上下左右的边界范围
        int topBoundary = 0;
        int bottomBoundary = n - 1;
        int leftBoundary = 0;
        int rightBoundary = n - 1;
        // 用来存放值
        int value = 1;
        // 起始位置
        int startRol = 0;
        int startCol = 0;
        while (value <= n * n) {
            // 先往右边走 最上面边界向下扩
            for (int i = leftBoundary; i <= rightBoundary; i++) {
                newGenerateMatrix[topBoundary][i] = value++;
            }
            // 判断是否会越过边界
            if (++topBoundary > bottomBoundary) {
                break;
            }
            // 再往下面走 最右边边界向左扩
            for (int i = topBoundary; i <= bottomBoundary; i++) {
                newGenerateMatrix[i][rightBoundary] = value++;
            }
            // 判断是否会越过边界
            if (--rightBoundary < leftBoundary) {
                break;
            }
            // 再往左走 最下边界往上扩
            for (int i = rightBoundary; i >= leftBoundary; i--) {
                newGenerateMatrix[bottomBoundary][i] = value++;
            }
            if (--bottomBoundary < topBoundary) {
                break;
            }
            // 再往上走 最左边界向右扩
            for (int i = bottomBoundary; i >= topBoundary; i--) {
                newGenerateMatrix[i][leftBoundary] = value++;
            }
            if (++leftBoundary > rightBoundary) {
                break;
            }
        }
        return newGenerateMatrix;
    }
}