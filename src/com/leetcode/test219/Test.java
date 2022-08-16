package com.leetcode.test219;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 2022/5/8 7:50
 *
 * @author chris
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1};
        int k = 1;
        Solution solution = new Solution();
        System.out.println(solution.containsNearbyDuplicate(nums, k));
    }
}

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}

class Solution02 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}

