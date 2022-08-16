package com.leetcode.test168;

/**
 * @author chris
 * @version V1.0
 * @package com.leetcode.test168
 * @date 2022/4/6 10:27
 */

public class Test {
    public static void main(String[] args) {
        int columnNumber = 28;
        int binNum = 10000;
        Solution solution = new Solution();
        System.out.println(solution.convertToTitle(columnNumber));
        System.out.println(solution.binaryTransition(binNum));
    }
}


class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber != 0) {
            int cur = columnNumber % 26;
            columnNumber /= 26;
            if (cur == 0) {
                sb.append('Z');
                columnNumber--;
            } else {
                sb.append((char) ('A' + cur - 1));
            }
        }
        return sb.reverse().toString();
    }


    public String binaryTransition(int num) {
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int cur = num % 2;
            num /= 2;
            if (cur == 0) {
                sb.append(0);
            } else {
                sb.append(cur);
            }
        }
        return sb.reverse().toString();
    }
}


