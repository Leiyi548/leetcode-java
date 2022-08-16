package com.leetcode.test169;

import java.util.HashMap;

/**
 * @author chris
 * @version V1.0
 * @package com.leetcode.test169
 * @date 2022/4/3 23:34
 */

public class Test {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        Solution solution = new Solution();
        System.out.println(solution.majorityElement(nums));
    }
}

class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int count;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            count = map.getOrDefault(nums[i], 0) + 1;
            if (count > n / 2) {
                return nums[i];
            }
            map.put(nums[i], count);

        }
        return nums[0];
    }
}
