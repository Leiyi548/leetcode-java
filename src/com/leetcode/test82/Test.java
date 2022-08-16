package com.leetcode.test82;


/**
 * @author chris
 * @version V1.0
 * @package com.力扣.test82
 * @date 2022/3/20 12:59
 */

public class Test {
    public static void main(String[] args) {
        ListNode listNodeByTail = new ListNode().createListNodeByTail(7);
        listNodeByTail = new Solution().deleteDuplicates(listNodeByTail);
        new ListNode().printListNode(listNodeByTail);
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
    public ListNode deleteDuplicates(ListNode head) {
        // 定义虚拟头结点,因为接下来操作有可能会删除头结点
        ListNode dummyHead = new ListNode(0);
        // 让它指向head
        dummyHead.next = head;

        ListNode prev = dummyHead;
        // 表示当前所在的链表位置
        ListNode cur = prev.next;
        while (cur != null) {
            // 定义重复的元素数字在链表
            int repeatNumber = 0;
            ListNode diffNode = cur;
            while (diffNode != null && diffNode.val == cur.val) {
                repeatNumber++;
                diffNode = diffNode.next;
            }
            if (repeatNumber > 1) {
                prev.next = diffNode;
            } else {
                prev = cur;
            }
            cur = diffNode;
        }
        return dummyHead.next;
    }
}
