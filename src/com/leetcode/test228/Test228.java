package com.leetcode.test228;

import java.util.ArrayList;
import java.util.List;

/**
 * 2022/5/12 11:14
 *
 * @author chris
 * @version 1.0
 */
public class Test228 {
    public static void main(String[] args) {
        int[] nums = {0, 2, 3, 4, 6, 8, 9};
        Solution solution = new Solution();
        System.out.println(solution.summaryRanges(nums));
    }
}

class Solution {
    private List<String> ans = new ArrayList<>();

    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            int low = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int high = i - 1;
            StringBuffer sb = new StringBuffer();
            sb.append(nums[low]);
            if (low < high) {
                sb.append("->");
                sb.append(Integer.toString(nums[high]));
            }
            ans.add(sb.toString());
        }
        return ans;
    }
}
