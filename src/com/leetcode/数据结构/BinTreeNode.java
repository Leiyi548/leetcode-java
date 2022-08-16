package com.leetcode.数据结构;

/**
 * @author Leiyi548
 * @package com.力扣.数据结构
 * @project leetcode
 * @created 2022/3/11 14:01 周五
 */
public class BinTreeNode<E> {
    E data;
    BinTreeNode lChild;
    BinTreeNode rChild;

    public BinTreeNode(E data) {
        this.data = data;
        this.lChild = null;
        this.rChild = null;
    }

    public BinTreeNode(E data, BinTreeNode lChild, BinTreeNode rChild) {
        this.data = data;
        this.lChild = lChild;
        this.rChild = rChild;
    }

    public BinTreeNode() {
        this.lChild = null;
        this.rChild = null;
    }
}
