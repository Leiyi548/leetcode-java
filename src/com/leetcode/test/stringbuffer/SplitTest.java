package com.leetcode.test.stringbuffer;

/**
 * @author chris
 * @version V1.0
 * @package com.leetcode.test.stringbuffer
 * @date 2022/4/7 10:30
 */

public class SplitTest {
    public static void main(String[] args) {
        String str = new String("Welcome-to-Runoob");

        System.out.println("- 分隔符返回值 :");
        for (String retval : str.split("-")) {
            System.out.println(retval);
        }

        System.out.println("");
        System.out.println("- 分隔符设置分割份数返回值 :");
        for (String retval : str.split("-", 2)) {
            System.out.println(retval);
        }

        System.out.println("");
        String str2 = new String("www.runoob.com");
        System.out.println("转义字符返回值 :");
        for (String retval : str2.split("\\.", 3)) {
            System.out.println(retval);
        }

        System.out.println("");
        String str3 = new String("acount=? and uu =? or n=?");
        System.out.println("多个分隔符返回值 :");
        for (String retval : str3.split("and|or")) {
            System.out.println(retval);
        }
    }
}
