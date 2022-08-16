package com.leetcode.test.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 *
 * @author chris
 * @version 1.0
 * @created 2022/4/10 15:39
 */
public class Test {
    public static void main(String[] args) {
        // TODO:匹配所有四个数字
        String content = "1998 年 12 月 8 日，第二代 Java 平台的企业版 J2EE 发布。1999 年 6 月，Sun 公司发布了"
                +
                "第二代 Java 平台（简称为 Java2）的 3 个版本：J2ME（Java2 Micro Edition，Java2 平台的微型" +
                "版），应用于移动、无线及有限资源的环境；J2SE（Java 2 Standard Edition，Java 2 平台的" +
                "标准版），应用于桌面环境；J2EE（Java 2Enterprise Edition，Java 2 平台的企业版），应" +
                "用 3443 于基于 Java 的应用服务器。Java 2 平台的发布，是 Java 发展过程中最重要的一个" +
                "里程碑，标志着 Java 的应用开始普及 9889 ";
        // \\d 表示任意一个数字
        String regStr = "(\\d\\d)(\\d\\d)";
        // 创建模式对象
        Pattern pattern = Pattern.compile(regStr);
        // 创建匹配器
        Matcher matcher = pattern.matcher(content);
        // 开始匹配
        matcher.find();
        System.out.println(matcher.group(0));
        for (int i = 0; i <= matcher.groupCount(); i++) {
            System.out.println("第" + i + "组:" + matcher.group(i));
        }
    }

    @org.junit.jupiter.api.Test
    public void example01() {
        String content = "I am noob " +
                "from runoob.com.";

        String pattern = ".*runoob.*";

        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);
    }

    @org.junit.jupiter.api.Test
    public void example02() {
        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(\\D*)(\\d+)(.*)";
        // 一共有3组
        // group(1) ==> (\\D*):匹配非数字零次或多次 *代表零次或多次匹配前面的字符或子表达式。
        // group(2) ==> (\\d+):匹配数字一次或多次
        // group(3) ==> (.*): .:匹配除"\r\n"之外的任何单个字符。*:代表零次或多次匹配前面的字符或子表达式
        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.find()) {
            System.out.println("Found value: " + m.group(0));
            System.out.println("Found value: " + m.group(1));
            System.out.println("Found value: " + m.group(2));
            System.out.println("Found value: " + m.group(3));
        } else {
            System.out.println("NO MATCH");
        }
    }

    @org.junit.jupiter.api.Test
    public void example03() {
        System.out.println("\\");
        System.out.println("\\\\");
    }
}

