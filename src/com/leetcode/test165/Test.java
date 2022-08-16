package com.leetcode.test165;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 *
 * @author chris
 * @version 1.0
 * @created 2022/4/10 10:45
 */
public class Test {
    public static void main(String[] args) {
        String version1 = "1.0.0";
        String version2 = "1.0";
//        String[] version1Arr = version1.split("\\.");
//        String[] version2Arr = version2.split("\\.");
//        System.out.println(Arrays.toString(version1Arr));
//        System.out.println(Arrays.toString(version2Arr));
        Solution solution = new Solution();
        System.out.println(solution.compareVersion(version1, version2));
    }
}

class Solution {
    public int compareVersion(String version1, String version2) {
        // 切记,这里要分割 "." 这个需要用 "\\"来进行转义
        String[] version1Arr = version1.split("\\.");
        String[] version2Arr = version2.split("\\.");
        int n1 = version1Arr.length;
        int n2 = version2Arr.length;
        for (int i = 0; i < n1 || i < n2; i++) {
            int x = 0;
            int y = 0;
            if (i < n1) {
                x = Integer.valueOf(version1Arr[i]);
            }
            if (i < n2) {
                y = Integer.valueOf(version2Arr[i]);
            }

            if (x > y) {
                return 1;
            } else if (x < y) {
                return -1;
            }
        }
        return 0;
    }
}
