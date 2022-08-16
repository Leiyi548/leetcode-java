package com.leetcode.test220;

import java.util.TreeSet;

/**
 * Created by IntelliJ IDEA.
 *
 * @author chris
 * @version 1.0
 * @created 2022/4/12 9:50
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        int t = 0;
        Solution solution = new Solution();
        System.out.println(solution.containsNearbyAlmostDuplicate(nums, k, t));
    }
}

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> ts = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            Long u = (long) nums[i];
            // 从 ts 中找到小于等于 u 的最大值（小于等于 u 的最接近 u 的数）
            Long l = ts.floor(u);
            // 从 ts 中找到大于等于 u 的最小值（大于等于 u 的最接近 u 的数）
            Long r = ts.ceiling(u);
            if (l != null && u - l <= t) {
                return true;
            }
            if (r != null && r - u <= t) {
                return true;
            }
            // 将当前数加到 ts 中，并移除下标范围不在 [max(0, i - k), i) 的数（维持滑动窗口大小为 k）
            ts.add(u);
            if (i >= k) {
                ts.remove(nums[i - k] * 1L);
            }
        }
        return false;
    }
}