package com.leetcode.test167;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2022/5/7 10:15
 *
 * @author chris
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 4, 9, 56, 90};
        int target = 8;
        Solution solution = new Solution();
        printArr(solution.twoSum(numbers, target));
    }

    public static void printArr(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                System.out.print("[" + nums[i] + ",");
                continue;
            }
            if (i == n - 1) {
                System.out.println(nums[i] + "]");
                continue;
            }
            System.out.print(nums[i] + ",");
        }
    }
}

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return null;
    }
}

class Solution02 {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int low = i + 1, high = numbers.length - 1;
            while (low <= high) {
                // 二分查找
                int mid = (high - low) / 2 + low;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return new int[]{-1, -1};
    }
}