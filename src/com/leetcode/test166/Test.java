package com.leetcode.test166;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @author chris
 * @version 1.0
 * @created 2022/4/11 10:16
 */
public class Test {
    public static void main(String[] args) {
        // 分子 numerator 分母 denominator
        int numerator, denominator;
        numerator = 4;
        denominator = 333;
        Solution solution = new Solution();
        System.out.println(solution.fractionToDecimal(numerator, denominator));
    }
}

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        // 转long计算,防止溢出
        long a = numerator, b = denominator;
        // 能整除直接返回结果
        if (a % b == 0) {
            return String.valueOf(a / b);
        }
        StringBuilder sb = new StringBuilder();
        // 判断符号
        if (a * b < 0) {
            sb.append('-');
        }
        a = Math.abs(a);
        b = Math.abs(b);
        // 计算小数点前面的部分,并将余数赋值给a
        sb.append(String.valueOf(a / b)).append(".");
        a = a % b;
        Map<Long, Integer> map = new HashMap<>();
        while (a != 0) {
            // 记录当前余数所在答案的位置,并继续模拟除法运算
            map.put(a, sb.length());
            a *= 10;
            // 将这个结果加入到结果
            sb.append(a / b);
            // 相当于减去上面的结果
            a %= b;
            // 如果当余数之前出现过,则将 出现位置到当前位置的部分抠出来 (循环小数部分)
            if (map.containsKey(a)) {
                int u = map.get(a);
                return String.format("%s(%s)", sb.substring(0, u), sb.substring(u));
            }
        }
        return sb.toString();
    }
}
