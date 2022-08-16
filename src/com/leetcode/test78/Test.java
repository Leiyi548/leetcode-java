package com.leetcode.test78;
/**
 * @Package com.力扣.test78
 * @author chris
 * @date 2022/3/16 8:21
 * @version V1.0
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Test
 * @Description: TODO
 * @Date: 2022/3/16 8:21
 * @Author: chris
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Solution().subsets(nums));
    }
}

class Solution {
    private List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        // 先给数组进行排序
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<>();
        dfs(nums, path, 0, 0);
        return res;
    }

    public void dfs(int[] nums, List<Integer> path, int startIndex, int depth) {
        int n = nums.length;
        if (depth > n) {
            return;
        }
        List<Integer> tempPath = new ArrayList<>(path);
        res.add(tempPath);
        for (int i = startIndex; i < n; i++) {
            path.add(nums[i]);
            dfs(nums, path, i + 1, depth + 1);
            path.remove(path.size() - 1);
        }
    }
}
