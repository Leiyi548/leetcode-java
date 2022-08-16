package com.leetcode.test216;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2022/5/10 10:36
 *
 * @author chris
 * @version 1.0
 */
public class Test216 {
    public static void main(String[] args) {
        int k = 3, n = 7;
        Solution solution = new Solution();
        System.out.println(solution.combinationSum3(k, n));
    }
}

class Solution {
    int n, k;

    public List<List<Integer>> combinationSum3(int _k, int _n) {
        n = _n;
        k = _k;

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(1, ans, cur, 0);
        return ans;
    }

    /**
     * u: 当前遍历到的数字
     * ans: 最终结果集
     * cur: 当前结果集
     * sum: 当前结果集的总和
     */
    void dfs(int u, List<List<Integer>> ans, List<Integer> cur, int sum) {
        if (sum == n && cur.size() == k) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        if (u == 10 || sum > n || cur.size() > k) {
            return;
        }
        // 使用数字 u
        cur.add(u);
        dfs(u + 1, ans, cur, sum + u);
        // 进行回溯
        cur.remove(cur.size() - 1);
        // 不使用数字 u
        dfs(u + 1, ans, cur, sum);
    }
}