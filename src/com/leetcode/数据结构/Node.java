package com.leetcode.数据结构;

import java.util.List;

/**
 * @author Leiyi548
 * @package com.力扣.数据结构
 * @project leetcode
 * @created 2022/3/10 15:23 周四
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
