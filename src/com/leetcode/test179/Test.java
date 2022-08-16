package com.leetcode.test179;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author chris
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        Solution solution = new Solution();
        System.out.println(solution.largestNumber(nums));
    }
}

class Solution {
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(String.valueOf(num));
        }
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String str1 = o1 + o2;
                String str2 = o2 + o1;
                return str2.compareTo(str1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }
        if (sb.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }

}