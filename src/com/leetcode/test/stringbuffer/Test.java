package com.leetcode.test.stringbuffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chris
 * @version V1.0
 * @package com.leetcode.test.stringbuffer
 * @date 2022/4/5 19:32
 */

public class Test {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int[] arr3 = {1, 2, 3, 4};
        int[] arr4 = null;
        int[] arr5 = null;
        int[] arr2 = Arrays.copyOf(arr, 5);
//        System.out.println(Arrays.toString(arr2));
        System.out.println(arr == arr3);
        List aslist = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("aslist->" + aslist);
        System.out.println(aslist.getClass());
    }
}
