package com.leetcode.test134;

/**
 * 2022/5/6 10:42
 *
 * @author chris
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        Solution solution = new Solution();
        System.out.println(solution.canCompleteCircuit(gas, cost));
    }
}

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int i = 0;
        int n = gas.length;
        // 通过暴力法,从每个起点都出发试一试,如果都不行直接返回-1
        while (i < n) {
            int sumOfGas = 0, sumOfCost = 0;
            int cnt = 0;
            while (cnt < n) {
                int j = (i + cnt) % n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                if (sumOfCost > sumOfGas) {
                    break;
                }
                cnt++;
            }
            if (cnt == n) {
                return i;
            } else {
                i = i + cnt + 1;
            }
        }
        return -1;
    }
}
