package com.leetcode.test75;
/**
 * @Package com.力扣.test75
 * @author chris
 * @date 2022/3/14 14:23
 * @version V1.0
 */

import java.util.Arrays;

/**
 * @ClassName: Test
 * @Description: TODO
 * @Date: 2022/3/1414:23
 * @Author: chris
 */

public class Test {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        Solution solution = new Solution();
        solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}


class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        // 如果长度小于2就不用排序
        if (len < 2) {
            return;
        }

        // 三指针来操作
        // all in [0, zero) = 0
        // all in [zero, i) = 1
        // all in [two, len - 1] = 2

        // 循环终止条件是 i == two，那么循环可以继续的条件是 i < two
        // 为了保证初始化的时候 [0, zero) 为空，设置 zero = 0，
        // 所以下面遍历到 0 的时候，先交换，再加
        int zero = 0;

        // 为了保证初始化的时候 [two, len - 1] 为空，设置 two = len
        // 所以下面遍历到 2 的时候，先减，再交换
        int two = len;
        int i = 0;
        // 当 i == two 上面的三个子区间正好覆盖了全部数组
        // 因此，循环可以继续的条件是 i < two
        while (i < two) {
            if (nums[i] == 0) {
                swap(nums, i, zero);
                zero++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                two--;
                swap(nums, i, two);
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}