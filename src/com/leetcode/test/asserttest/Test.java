package com.leetcode.test.asserttest;

/**
 * @author chris
 * @version V1.0
 * @package com.leetcode.test.asserttest
 * @date 2022/4/3 11:10
 */

public class Test {
    public static void main(String[] args) {
        String[] weekends = {"Friday", "Saturday", "Sunday"};
        assert weekends.length == 3;
        System.out.println("这个星期有 " + weekends.length + " 个周末");
    }
}
