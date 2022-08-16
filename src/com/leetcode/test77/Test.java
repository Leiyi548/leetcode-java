package com.leetcode.test77;
/**
 * @Package com.力扣.test77
 * @author chris
 * @date 2022/3/15 11:16
 * @version V1.0
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Test
 * @Description: TODO: write leetcode
 * @Date: 2022/3/15 11:16
 * @Author: chris
 */
public class Test {
    public static void main(String[] args) {
        int n = 1, k = 1;
        System.out.println(new Solution().combine(n, k));
    }
}

class Solution {
    private List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> path = new ArrayList<>();
        dfs(1, n, k, path, 0);
        return res;
    }

    public void dfs(int startIndex, int n, int k, List<Integer> path, int depth) {
        if (depth == k) {
            List<Integer> tempPath = new ArrayList<>(path);
            res.add(tempPath);
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            dfs(i + 1, n, k, path, depth + 1);
            path.remove(path.size() - 1);
        }

    }
}
