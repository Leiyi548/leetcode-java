package com.leetcode.test56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Leiyi548
 * @package com.力扣.test56
 * @project leetcode
 * @created 2022/3/4 10:26 周五
 */
public class Test {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6,}, {8, 10}, {15, 18}};
        Solution solution = new Solution();
        printArr(solution.merge(intervals));
    }

    public static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf(String.valueOf(arr[i][j]) + " ");
            }
            System.out.printf("]");
            System.out.println();
        }
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {
        //思路：
        //1.先将二维数组每一行按第一列排序得到诸如 [ [0,2], [1,5], [6,8], [10,11] ]
        //2.循环遍历每一行,给结果数组添加数据,有以下添加情况
        //3.对于结果数组 merge 的第一行,直接 add 进去即先将 [0,2] 添加
        //4.对于 merge 的其他行,若无重叠也直接添加如 [6,8], [10,11]
        //5.若有重叠,则修改上一行如 [0,2], [1,5] -> [0,5]

        int n = intervals.length;

        //通过 sort 函数对二维数组每一行按第一列元素进行排序
        //重写比较器方法,o1[] - o2[] 表示当 o1 大于 o2 时,将 o1 放在 o2 后面,即基本的升序排序
        //而 o1[0] - o2[0] 表示按二维数组的每一行第一列元素排序,类似的 o[1] - o2[1]代表按第二列进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        // 创建list里面存放了一维数组
        List<int[]> merge = new ArrayList<int[]>();

        for (int i = 0; i < n; i++) {

            //创建变量指向每行的左右元素(两列) [左右指针]
            int left = intervals[i][0];
            int right = intervals[i][1];

            //直接 add 的情况：当为第一行或者相邻两行无重叠时
            //解释：两行无重叠,即对应在 merge 中上一行的第 1 列小于本行第 0 列
            if (merge.size() == 0 || merge.get(merge.size() - 1)[1] < left) {
                // 添加数据
                merge.add(new int[]{left, right});
            }
            //合并的情况：当有重叠时,将 merge 中上一行的右边界更新
            else {
                merge.get(merge.size() - 1)[1] = Math.max(merge.get(merge.size() - 1)[1], right);
            }
        }
        //可以学习下此种将 list 转二维数组的方法
        return merge.toArray(new int[merge.size()][]);
    }
}