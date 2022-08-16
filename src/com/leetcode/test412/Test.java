package com.leetcode.test412;

import java.util.ArrayList;
import java.util.List;

/**
 * 2022/4/29 9:28
 *
 * @author chris
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        int n = 3;
        Solution solution = new Solution();
        System.out.println(solution.fizzBuzz(n));
    }
}

class Solution {
    List<String> list = new ArrayList<>();

    public List<String> fizzBuzz(int n) {
        for (int i = 1; i <= n; i++) {
            // 如果同时能被3和5整除
            if (i % 3 == 0 && i % 5 == 0) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }
}