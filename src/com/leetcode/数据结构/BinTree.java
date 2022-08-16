package com.leetcode.数据结构;

import java.util.Stack;

/**
 * @author Leiyi548
 * @package com.力扣.数据结构
 * @project leetcode
 * @created 2022/3/11 10:44 周五
 */
public class BinTree {
    BinTreeNode<Character> root;
    private String binTreeStr = "";

    public BinTree() {
        root = null;
    }

    public BinTreeNode<Character> getRoot() {
        return root;
    }

    public void setRoot(BinTreeNode<Character> root) {
        this.root = root;
    }

    public String getBinTreeStr() {
        return binTreeStr;
    }

    public void setBinTreeStr(String binTreeStr) {
        this.binTreeStr = binTreeStr;
    }

    /**
     * 根据字符串创建二叉树
     *
     * @param s 二叉树的字符串表示 "A(B(D(,G),),C(E,F))"
     */
    public void createBinTree(String s) {
        Stack<BinTreeNode> stack = new Stack<BinTreeNode>();
        BinTreeNode<Character> prevNode = null;
        int i = 0;
        // 判断处理的是否是左节点
        boolean flag = true;
        char ch;
        int len = s.length();
        while (i < len) {
            ch = s.charAt(i);
            // 代表前面一个节点是根节点
            if (ch == '(') {
                stack.push(prevNode);
                flag = true;
            } else if (ch == ',') {
                flag = false;
            } else if (ch == ')') {
                stack.pop();
            } else {
                prevNode = new BinTreeNode<Character>(ch);
                if (root == null) {
                    root = prevNode;
                } else {
                    if (flag) {
                        stack.peek().lChild = prevNode;
                    } else {
                        stack.peek().rChild = prevNode;
                    }
                }
            }
            i++;
        }
    }

    /**
     * 通过二叉树输出字符串
     *
     * @param tree 二叉树
     */
    public void printBinTree(BinTreeNode<Character> tree) {
        if (tree != null) {
            binTreeStr += tree.data;
            if (tree.lChild != null || tree.rChild != null) {
                binTreeStr += "(";
                this.printBinTree(tree.lChild);
                binTreeStr += ",";
                this.printBinTree(tree.rChild);
                binTreeStr += ")";
            }
        }
    }

}
