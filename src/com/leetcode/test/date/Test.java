package com.leetcode.test.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author chris
 * @version V1.0
 * @package com.leetcode.test.date
 * @date 2022/4/6 16:08
 */

public class Test {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入格式为yyyy-MM-dd的日期");
        String dateString = scanner.next();
        try {
            Date newDate = simpleDateFormat.parse(dateString);
            System.out.printf("%tF%n", newDate);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
