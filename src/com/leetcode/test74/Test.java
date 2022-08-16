package com.leetcode.test74;

/**
 * @author Leiyi548
 * @package com.力扣.test74
 * @project leetcode
 * @created 2022/3/13 9:35 周日
 */
public class Test {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(new Solution().searchMatrix(matrix, 9));
    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 获得行列大小
        int m = matrix.length, n = matrix[0].length;
        // 获得这个矩阵的大小边界
        int minLimit = matrix[0][0], maxLimit = matrix[m - 1][n - 1];
        if (target < minLimit || target > maxLimit) {
            return false;
        }
        // 每行的最小值
        int[] rowMinLimit = new int[m];
        int[] rowMaxLimit = new int[m];
        for (int i = 0; i < m; i++) {
            rowMinLimit[i] = matrix[i][0];
            rowMaxLimit[i] = matrix[i][n - 1];
        }

        for (int i = 0; i < m; i++) {
            if (target >= rowMinLimit[i] || target <= rowMaxLimit[i]) {
                for (int j = 0; j < n; j++) {
                    if (target == matrix[i][j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}


class Solution02 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;
        int left = 0;
        int right = row - 1;
        //对行进行二分查找
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] > target) {
                right = mid - 1;
            } else if (matrix[mid][0] < target) {
                if (matrix[mid][column - 1] >= target) {
                    break;
                } else {
                    left = mid + 1;
                }
            }
        }
        //对列进行二分查找
        int fixed_row = (left + right) / 2;
        left = 0;
        right = column - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[fixed_row][mid] == target) {
                return true;
            } else if (matrix[fixed_row][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }
}