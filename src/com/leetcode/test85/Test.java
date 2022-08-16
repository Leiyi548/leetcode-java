package com.leetcode.test85;

/**
 * @author chris
 * @version V1.0
 * @package com.力扣.test85
 * @date 2022/3/22 17:11
 */

public class Test {
    public static void main(String[] args) {
        ListNode node = new ListNode().createListNodeByTail(2);
        int target = 2;
        Solution solution = new Solution();
        node.printListNode(solution.partition(node, target));
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
    public ListNode partition(ListNode head, int x) {
        // 先把这个转换为数组
        // [1,4,3,2,5,2] -> [1,2,2,4,3,5]
        // 然后将这个数组进行排序,再把数组转化成链表
        int[] arr = convertArray(head);
        int[] sortArr = sort(arr, x);
        return arraysToListNode(sortArr);
    }

    public ListNode arraysToListNode(int[] arr) {
        int n = arr.length;
        ListNode dummyHead = new ListNode(0);
        ListNode r = null;
        for (int i = 0; i < n; i++) {
            ListNode node = new ListNode(arr[i], null);
            if (i == 0) {
                dummyHead.next = node;
            } else {
                r.next = node;
            }
            r = node;
        }
        return dummyHead.next;
    }

    public int[] sort(int[] arr, int target) {
        int n = arr.length;
        int[] newArr = new int[n];
        boolean[] visited = new boolean[n];
        int index = 0;
        // 把小于target的先给放进去
        for (int i = 0; i < n; i++) {
            if (arr[i] < target) {
                newArr[index++] = arr[i];
                visited[i] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                newArr[index++] = arr[i];
            }
        }
        return newArr;
    }

    public int[] convertArray(ListNode head) {
        ListNode list = head;
        int n = getLength(list);
        int[] arr = new int[n];
        int i = 0;
        while (list != null) {
            arr[i] = list.val;
            list = list.next;
            i++;
        }
        return arr;
    }

    public int getLength(ListNode head) {
        ListNode list = head;
        int n = 0;
        while (list != null) {
            list = list.next;
            n++;
        }
        return n;
    }
}

class Solution02 {
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode();
        ListNode moreHead = new ListNode();

        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode curLess = lessHead;
        ListNode curMore = moreHead;

        while (cur != null) {
            if (cur.val < x) {
                curLess.next = new ListNode(cur.val);
                curLess = curLess.next;
                cur = cur.next;
            } else {
                curMore.next = new ListNode(cur.val);
                curMore = curMore.next;
                cur = cur.next;
            }
        }
        // 连接两个链表
        curLess.next = moreHead.next;
        return lessHead.next;
    }
}