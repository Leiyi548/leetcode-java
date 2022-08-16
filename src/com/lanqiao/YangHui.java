package com.lanqiao;

import java.util.Scanner;

/**
 * @author Leiyi548
 * @date 2022/2/27 16:12
 */
public class YangHui {
    public static void main(String[] args) {
        long n;
        long ans = 1;
        boolean flag = false;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextLong();
        long[][] arr = new long[100][];
        for (int i = 0; i < 100; i++) {
            arr[i] = new long[i + 1];
            for (int j = 0; j < arr[i].length; j++) {
                if (j == 0 || j == arr[i].length - 1) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
            }

        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == n) {
                    System.out.println(ans);
                    flag = true;
                    break;
                }
                if (flag) break;
                ans++;
            }
        }
    }
}
