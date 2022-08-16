package com.leetcode.test.regexp;

/**
 * Created by IntelliJ IDEA.
 *
 * @author chris
 * @version 1.0
 * @created 2022/4/10 19:12
 */
public class Copilot {
    // 冒泡排序
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // 快速排序
    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int i = start;
            int j = end;
            int key = arr[i];
            while (i < j) {
                while (i < j && arr[j] >= key) {
                    j--;
                }
                if (i < j) {
                    arr[i] = arr[j];
                    i++;
                }
                while (i < j && arr[i] <= key) {
                    i++;
                }
                if (i < j) {
                    arr[j] = arr[i];
                    j--;
                }
            }
            arr[i] = key;
            quickSort(arr, start, i - 1);
            quickSort(arr, i + 1, end);
        }
    }
}
