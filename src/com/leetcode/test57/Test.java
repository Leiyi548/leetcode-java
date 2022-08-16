package com.leetcode.test57;

import java.util.Arrays;

/**
 * @author Leiyi548
 * @package com.力扣.test57
 * @project leetcode
 * @created 2022/3/5 12:55 周六
 */
public class Test {
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        Solution solution = new Solution();
        printArr(solution.insert(intervals, newInterval));
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
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 定义最大空间
        int[][] res = new int[intervals.length + 1][];
        int index = 0;
        int i = 0;
        // 首先将新区间左边且相离的区间加入结果集
        // （遍历时，如果当前区间的结束位置小于新区间的开始位置，说明当前区间在新区间的左边且相离）；
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            res[index++] = intervals[i++];
        }
        // 接着判断当前区间是否与新区间重叠，重叠的话就进行合并，直到遍历到当前区间在新区间的右边且相离，将最终合并后的新区间加入结果集；
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        // 最后将新区间右边且相离的区间加入结果集。
        res[index++] = newInterval;
        while (i < intervals.length) {
            res[index++] = intervals[i++];
        }
        return Arrays.copyOf(res, index);
    }
}
