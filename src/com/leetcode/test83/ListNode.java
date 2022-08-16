package com.leetcode.test83;

import java.util.Scanner;

/**
 * @author chris
 * @version V1.0
 * @package com.力扣.test83
 * @date 2022/3/21 14:41
 */


public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
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
                tail.next = newNode;
            }
            tail = newNode;
        }
        return head;
    }

    /**
     * 输出ListNode
     *
     * @param head ListNode head
     */
    public void printListNode(ListNode head) {
        System.out.println("===显示链表信息===");
        while (head != null) {
            if (head.next == null) {
                System.out.println(head.val);
                head = head.next;
                break;
            }
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("===显示完毕===");
    }
}