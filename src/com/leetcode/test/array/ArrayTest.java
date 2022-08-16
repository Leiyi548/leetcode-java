package com.leetcode.test.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chris
 * @version V1.0
 * @package com.leetcode.test.array
 * @date 2022/4/3 13:09
 */

public class ArrayTest {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 7, 8};
        System.out.println("不改变Comparator接口,按照升序方法排序");
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("改变Comparator接口,按照升序方法排序");
    }
}
