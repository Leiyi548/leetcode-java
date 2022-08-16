package com.leetcode.test01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2022/6/1 10:44
 *
 * @author chris
 * @version 1.0
 */
public class Test01 {
    public static void main(String[] args) {
        int[] nums = {3, 3};
        int target = 6;
        int testValCursor = 99;
        testValCursor = 100;
        System.out.println(testValCursor);
        Solution02 solution = new Solution02();
        System.out.println(Arrays.toString(solution.twoSum(nums, target)));
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}

class Solution02 {
    public int[] twoSum(int[] nums, int target) {
        // 建立一个哈希表，然后我们将每次得到的值放进去，然后哪次刚好就将它的下标返回，就行。
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 获得两个差值，并且把下标给存储起来
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            } else {
                int val = target - nums[i];
                map.put(val, i);
            }
        }
        return new int[]{-1, -1};
    }
}
