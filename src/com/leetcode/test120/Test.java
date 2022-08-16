package com.leetcode.test120;

import java.util.List;

/**
 * 2022/5/3 10:12
 *
 * @author chris
 * @version 1.0
 */
public class Test {
}

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int ans = Integer.MAX_VALUE;
        int n = triangle.size();
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i - 1).get(j));
                } else if (j == i) {
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i - 1).get(j - 1));
                } else {
                    triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i - 1).get(j), triangle.get(i - 1).get(j - 1)));
                }
            }
        }
        for (Integer integer : triangle.get(n - 1)) {
            if (integer < ans) {
                ans = integer;
            }
        }
        return ans;
    }
}
