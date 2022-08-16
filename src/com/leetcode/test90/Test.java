package com.leetcode.test90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chris
 * @version V1.0
 * @package com.力扣.test90
 * @date 2022/3/25 12:46
 */

public class Test {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        Solution solution = new Solution();
        System.out.println(solution.subsetsWithDup(nums));
    }
}


class Solution {
    /**
     * 存放符合条件结果的集合
     */
    List<List<Integer>> result = new ArrayList<>();
    /**
     * 用来存放符合条件结果
     */
    LinkedList<Integer> path = new LinkedList<>();
    /**
     * 用来判断这个数据有没有被使用
     */
    boolean[] used;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 特殊情况判断
        if (nums.length == 0) {
            result.add(path);
            return result;
        }
        // 先将数组进行排序
        Arrays.sort(nums);
        used = new boolean[nums.length];
        subsetsWithDupHelper(nums, 0);
        return result;
    }

    private void subsetsWithDupHelper(int[] nums, int startIndex) {
        result.add(new ArrayList<>(path));
        // 越界
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            // 上一个数字已经被读取了,
            // 在同一层的话used[i-1]是 false
            // 不是同一层的连续两个另个有可能是true
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            subsetsWithDupHelper(nums, i + 1);
            path.removeLast();
            used[i] = false;
        }
    }
}