package com.leetcode.数据结构;

/**
 * @author Leiyi548
 * @package com.力扣.数据结构
 * @project leetcode
 * @created 2022/3/10 15:57 周四
 */

public class ListNode {
    private int val;
    private ListNode next;

    public ListNode() {

    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
