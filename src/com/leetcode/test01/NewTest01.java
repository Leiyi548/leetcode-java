package com.leetcode.test01;


import java.util.HashMap;
import java.util.Map;

public class NewTest01 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        newSolution01 solution01 = new newSolution01();
        printArr(solution01.twoSum(nums, target));
        newSolution02 solution02 = new newSolution02();
        printArr(solution02.twoSum(nums, target));
    }

    public static void printArr(int[] arr) {
        int n = arr.length;

        System.out.print("[");
        for (int i = 0; i < n; i++) {
            if (i != n - 1) {
                System.out.printf("%d,", arr[i]);
            } else {
                System.out.printf("%d]\n", arr[i]);
            }
        }
    }
}

class newSolution01 {
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}


class newSolution02 {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            } else {
                int var = target - nums[i];
                map.put(var, i);
            }
        }
        return null;
    }
}
