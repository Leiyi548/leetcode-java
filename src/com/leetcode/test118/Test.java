package com.leetcode.test118;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chris
 * @version V1.0
 * @package com.leetcode.test118
 * @date 2022/4/1 15:13
 */

public class Test {
    public static void main(String[] args) {
        int numRows = 1;
        Solution solution = new Solution();
        System.out.println(solution.generate(numRows));
    }
}

class Solution {
    private List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> generate(int numRows) {
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                // 左右两边都为1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(row);
        }
        return res;
    }
}
