package com.leetcode.test80;

/**
 * @author chris
 * @version V1.0
 * @package com.力扣.test80
 * @date 2022/3/18 16:41
 */

public class Test {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(new Solution().removeDuplicates(nums));
    }
}


class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        // 特殊情况判断
        if (n <= 2) {
            return n;
        }
        // 最小结果也为2 数组前两个必然可以保留
        int slow = 2, fast = 2;
        while (fast < n) {
            // 因为这是有序数组,如果有超过两个数字相等连在一起
            // 那么会出现  nums[slow - 2] == nums[fast]
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
