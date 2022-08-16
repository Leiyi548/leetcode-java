package com.leetcode.test83;

/**
 * @author chris
 * @version V1.0
 * @package com.力扣.test83
 * @date 2022/3/21 14:33
 */

public class Test {
    public static void main(String[] args) {
        ListNode listNodeByTail = new ListNode().createListNodeByTail(5);
        Solution solution = new Solution();
        listNodeByTail = solution.deleteDuplicates(listNodeByTail);
        new ListNode().printListNode(solution.deleteDuplicates(listNodeByTail));
    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = head;
        int repeatNumber = 0;
        while (cur != null) {
            ListNode diffNode = cur;
            while (diffNode != null && diffNode.val == cur.val) {
                diffNode = diffNode.next;
                repeatNumber++;
            }
            if (repeatNumber > 1) {
                cur.next = diffNode;
            }
            cur = diffNode;
        }
        return dummyHead.next;
    }
}