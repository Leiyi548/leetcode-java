package com.leetcode.test415;

/**
 * 2022/4/26 9:42
 *
 * @author chris
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        String num1 = "11";
        String num2 = "123";
        Solution solution = new Solution();
        System.out.println(solution.addStrings(num1, num2));
    }
}

class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        // 一开始默认进位为0
        int carry = 0;
        // 从最后一个开始数字字符开始
        int i = num1.length() - 1, j = num2.length() - 1;
        // 如果还有进位
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + carry;
            sb.append(result % 10);
            // 更新进位
            carry = result / 10;
            i--;
            j--;
        }
        sb.reverse();
        return sb.toString();
    }
}