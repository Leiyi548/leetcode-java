package com.leetcode.test88;

import java.util.Arrays;

/**
 * @author chris
 * @version V1.0
 * @package com.力扣.test88
 * @date 2022/3/23 14:53
 */

public class Test {
    public static void main(String[] args) {
//        int[] nums1 = {1, 2, 3, 0, 0, 0};
//        int[] nums2 = {2, 5, 6};
        int[] nums1 = {3, 4, 5, 0, 0};
        int[] nums2 = {1, 2};
        Solution solution = new Solution();
        solution.merge(nums1, 3, nums2, 2);
        System.out.println(Arrays.toString(nums1));
    }
}

/**
 * 使用合并排序方法
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
}

class Solution02 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }
    }
}