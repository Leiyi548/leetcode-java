package com.leetcode.test394;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 2022/4/23 9:09
 *
 * @author chris
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        String s = "3[a2[c]]";
        Solution solution = new Solution();
        System.out.println(solution.decodeString(s));
    }
}

class Solution {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        // LinkedList<Integer> stack_multi = new LinkedList<>();
        // LinkedList<String> stack_res = new LinkedList<>();
        Stack<Integer> stack_multi = new Stack<>();
        Stack<String> stack_res = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                stack_multi.push(multi);
                stack_res.push(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.pop();
                for (int i = 0; i < cur_multi; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(stack_res.pop() + tmp);
            } else if (c >= '0' && c <= '9') {
                multi = multi * 10 + Integer.parseInt(c + "");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
