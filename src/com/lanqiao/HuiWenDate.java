package com.lanqiao;

import java.util.Scanner;

/**
 * @author Leiyi548
 * @date 2022/3/2 22:14
 */
public class HuiWenDate {
    public static void main(String[] args) {
        /**
         * 这道题很容易被误解到使用暴力法去解决这个问题
         * 但是如果你使用暴力法去解决这个问题，基本就会超时完蛋
         * 我们先看这个题目要求这个题目的名字是回文日期，说明我们输入进来的是个日期
         * 我们需要返回的其实也是个日期，所以我们要判断是否是日期。
         * 我们返回的结果是个字符串，我们看到这是个回文，我们只需要得到前面4个数字（也就是年份）
         * 然后我们再判断后面那几个数据，然后就可以进行年份加一来获得答案
         * 1.注意月份和日期不能为0
         */
        Scanner scanner = new Scanner(System.in);
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int date = scanner.nextInt();
        // 判断是否输入第一个回文日期
        boolean flag = false;
        // 获得输入的年月日
        int year = date / 10000;
        int month = date % 10000 / 100;
        int day = date % 100;
        int yearTerm = 89999;
        // 如果是闰年的话二月就是29天，正常年份都是28天
        if (isRunYear(year)) {
            days[1] = 29;
        } else {
            days[1] = 28;
        }
        // 我们要获得的是回文日期，所以我们得到了年份也就是year后面就是相反的
        // 比如 2021(year) 后面要接的是(12)月份+(02)日期
        // 月份就是21倒过来 m = 2021 % 10 * 10 + 2021 % 100 / 10 = 12
        // 日期就是20倒过来（02） d = 2021 / 100 % 10 * 10 + 2021 / 1000
        int m = year % 10 * 10 + year % 100 / 10;
        int d = year / 100 % 10 * 10 + year / 1000;

        // 如果今年的回文日期还没到的话，下一个就是今年的回文日期
        // 判断这一年的回文年在输入日期的后面
        if (m > month && m > 0 && m < 13) {
            if (d > day && d > 0 && d < days[m - 1]) {
                // 按照题目要求输出下一个回文日期
                System.out.println(year + String.format("%02d", m) + String.format("%02d", d));
                flag = true;
                // 判断是否是 ABAB - BABA类型的日期
                if (m == d) {
                    System.out.println(year + String.format("%02d", m) + String.format("%02d", d));
                }
                return;

            }
        }
        // 如果今年的回文日期已经到了的话,那么就只能判断明年的回文日期了
        while (year < yearTerm) {
            // 去明年判断
            year++;
            // 新的年份月日
            int newM = year % 10 * 10 + year % 100 / 10;
            int newD = year / 100 % 10 * 10 + year / 1000;
            if (newM > 12 || newM <= 0) continue;
            if (isRunYear(year)) {
                days[1] = 29;
            } else {
                days[1] = 28;
            }
            if (!flag && newD < days[newM - 1] && newD > 0 && newM > 0) {
                System.out.println(year + String.format("%02d", newM) + String.format("%02d", newD));
                flag = true;
            }
            // 判断是否是 ABAB - BABA类型的日期
            if (newM == newD) {
                System.out.println(year + String.format("%02d", newM) + String.format("%02d", newD));
                break;
            }

        }
    }

    public static boolean isRunYear(int year) {
        //闰年判断规则：
        //能被4和400整除的年份不能被100整除
        if (year % 400 == 0 && year % 4 == 0 || year % 100 != 0) return true;
        return false;
    }
}
