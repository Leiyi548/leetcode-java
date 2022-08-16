package com.leetcode.test.wrapper;

import java.util.Arrays;

/**
 * @author chris
 * @version V1.0
 * @package com.leetcode.test.wrapper
 * @date 2022/4/3 10:25
 */

public class StringBufferTest {
    public static void main(String[] args) {
        String[] arr = {"abc", "acd"};
        testArr(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void testArr(String[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            arr[i] = String.valueOf(i);
        }
    }

    public static void test(String s) {
        s = "abc";
    }
}
