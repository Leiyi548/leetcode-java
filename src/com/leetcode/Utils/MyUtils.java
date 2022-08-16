package com.leetcode.Utils;

import com.leetcode.数据结构.ListNode;

import java.util.Scanner;

/**
 * @author Leiyi548
 * @package com.力扣.Utils
 * @project leetcode
 * @created 2022/3/10 15:26 周四
 */
public class MyUtils {
    /**
     * 输出一维数组的信息(int)
     *
     * @param arr 一维数组
     */
    public void printOneDimensionalArray(int[] arr) {
        System.out.println("===输出一维数组===");
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
                break;
            }
            System.out.print(arr[i] + ",");
        }
        System.out.println("]");
    }

    /**
     * 输出一维数组的信息(char)
     *
     * @param arr 一维数组
     */
    public void printOneDimensionalArray(char[] arr) {
        System.out.println("===输出一维数组===");
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
                break;
            }
            System.out.print(arr[i] + ",");
        }
        System.out.println("]");
    }

    /**
     * 输出二维数组的信息
     *
     * @param arr 二维数组
     */
    public void printTwoDimensionArray(int[][] arr) {
        System.out.println("\n===输出二维数组===");
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[");
            for (int j = 0; j < arr[i].length; j++) {
                if (j == arr[i].length - 1) {
                    System.out.print(arr[i][j]);
                    break;
                }
                System.out.print(arr[i][j] + ",");
            }
            if (i == arr.length - 1) {
                System.out.print("]");
                break;
            }
            System.out.print("],");
        }
        System.out.print("]");

    }


    /**
     * 输出二维数组的信息
     *
     * @param arr 二维数组
     */
    public void printTwoDimensionArray(char[][] arr) {
        System.out.println("\n===输出二维数组===");
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[");
            for (int j = 0; j < arr[i].length; j++) {
                if (j == arr[i].length - 1) {
                    System.out.print(arr[i][j]);
                    break;
                }
                System.out.print(arr[i][j] + ",");
            }
            if (i == arr.length - 1) {
                System.out.print("]");
                break;
            }
            System.out.print("],");
        }
        System.out.print("]");

    }

    /**
     * 输出ListNode
     *
     * @param head ListNode head
     */
    public void printListNode(ListNode head) {
        System.out.println("===显示链表信息===");
        while (head != null) {
            if (head.getNext() == null) {
                System.out.println(head.getVal());
                head = head.getNext();
                break;
            }
            System.out.print(head.getVal() + "->");
            head = head.getNext();
        }
        System.out.println("===显示完毕===");
    }

    /**
     * 获得ListNode长度
     *
     * @param head ListNode head
     * @return
     */
    public int getListNodeLength(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.getNext();
            length++;
        }
        return length;
    }


    /**
     * 尾插法创建ListNode
     *
     * @param n ListNode的长度
     * @return 创建好的ListNode
     */
    public ListNode createListNodeByTail(int n) {
        ListNode head = null, tail = null, newNode = null;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            newNode = new ListNode(data, null);
            if (i == 0) {
                head = tail = newNode;
            } else {
                tail.setNext(newNode);
            }
            tail = newNode;
        }
        return head;
    }
}
