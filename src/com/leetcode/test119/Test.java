package com.leetcode.test119;

import java.util.ArrayList;
import java.util.List;

/**
 * 2022/4/14 12:56
 *
 * @author chris
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        int rowIndex = 3;
        Solution solution = new Solution();
        System.out.println(solution.getRow(rowIndex));
    }
}

class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<Integer> getRow(int rowIndex) {
        //先创建杨辉三角
        // 把最开始的一列给创建好
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(row);
        }
        return res.get(rowIndex);
    }
}
