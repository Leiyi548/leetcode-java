package com.leetcode.test61;

import java.util.Scanner;

/**
 * @author Leiyi548
 * @package com.力扣.test61
 * @project leetcode
 * @created 2022/3/7 14:39 周一
 */
public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter n (listNode length)");
        int n = scanner.nextInt();
        ListNode list = solution.createListNode(n);
        System.out.println("listNode information:");
        solution.printListNode(list);
        System.out.println("Reverse listNode");
        list = solution.rotateRight(list, 2);
        System.out.println("listNode information:");
        solution.printListNode(list);
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // 判断特殊情况
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int n = 1;
        ListNode iter = head;
        // 获得这个旋转链表的长度
        while (iter.next != null) {
            iter = iter.next;
            n++;
        }
        // 获得移动的距离（移动到需要移动的头结点的位置）
        int add = n - k % n;
        // 循环移动,所以没有移动,返回一开始的位置
        if (add == n) {
            return head;
        }
        iter.next = head;
        while (add-- > 0) {
            iter = iter.next;
        }
        ListNode ret = iter.next;
        // 因为形成了一个圆所以让他
        iter.next = null;
        return ret;
    }

    public ListNode createListNode(int n) {
        ListNode head, tail, newNode;
        tail = head = null;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            // 创建临时节点
            newNode = new ListNode(data, null);
            if (i == 0) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
            }
            tail = newNode;
        }
        return head;
    }

    public void printListNode(ListNode head) {
        ListNode list = head;
        while (list != null) {
            System.out.printf(String.valueOf(list.val));
            list = list.next;
        }
        System.out.println();
    }
}