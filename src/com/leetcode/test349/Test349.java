package com.leetcode.test349;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 2022/5/13 9:35
 *
 * @author chris
 * @version 1.0
 */
public class Test349 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        Solution02 solution = new Solution02();
        System.out.println(Arrays.toString(solution.intersection(nums1, nums2)));
    }
}

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            set2.add(num);
        }
        return getIntersection(set1, set2);
    }

    public int[] getIntersection(Set<Integer> set1, Set<Integer> set2) {
        if (set1.size() > set2.size()) {
            return getIntersection(set2, set1);
        }
        Set<Integer> togetherSet = new HashSet<>();
        for (int num : set1) {
            if (set2.contains(num)) {
                togetherSet.add(num);
            }
        }
        int[] ans = new int[togetherSet.size()];
        int index = 0;
        for (int num : togetherSet) {
            ans[index++] = num;
        }
        return ans;
    }
}

class Solution02 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int[] intersection = new int[length1 + length2];
        int index = 0, index1 = 0, index2 = 0;
        while (index1 < length1 && index2 < length2) {
            int num1 = nums1[index1], num2 = nums2[index2];
            if (num1 == num2) {
                if (index == 0 || num1 != intersection[index - 1]) {
                    intersection[index++] = num1;
                }
                index1++;
                index2++;
            } else if (num1 < num2) {
                index1++;
            } else {
                index2++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }
}
