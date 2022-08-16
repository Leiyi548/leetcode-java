package com.leetcode.test137;

import java.util.HashMap;
import java.util.Set;

/**
 * 2022/5/2 10:07
 *
 * @author chris
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 2};
        int num = 2 ^ 2;
        System.out.println("num = " + num);
        Solution solution = new Solution();
        System.out.println(solution.singleNumber(nums));
    }
}

class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int count;
        // 先用hashmap统计每个字母出现的次数
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 然后再遍历取出其中只出现过一次
        Set keySet = map.keySet();
        for (Object key : keySet) {
            if (map.get(key) == 1) {
                return (Integer) key;
            }
        }
        return -1;
    }
}
