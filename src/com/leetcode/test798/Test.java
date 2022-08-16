package com.leetcode.test798;

/**
 * @author Leiyi548
 * @package com.力扣.test798
 * @project leetcode
 * @created 2022/3/9 19:17 周三
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = {1, 3, 0, 2, 4};
//        int[] nums = {2, 3, 1, 4, 0};
        System.out.println(new Solution().bestRotation(nums));
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + " ");
        }
        System.out.println();
    }
}


class Solution {
    public int bestRotation(int[] nums) {
        // 获得初始分数
        int initialScore = getScore(nums);
        int maxScore = initialScore;
        int minIndex = 0;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            arrMove(nums);
            if (maxScore < getScore(nums)) {
                minIndex = i;
                maxScore = getScore(nums);
            }
        }
        return minIndex;
    }

    public void arrMove(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            swap(arr, i, i + 1);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int getScore(int[] arr) {
        int n = arr.length;
        int score = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= i) {
                score++;
            }
        }
        return score;
    }
}