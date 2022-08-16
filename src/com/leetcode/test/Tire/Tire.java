package com.leetcode.test.Tire;

/**
 * @author chris
 * @version V1.0
 * @package com.leetcode.test.Tire
 * @date 2022/4/5 16:37
 */

public class Tire {
    /**
     * 创建根节点
     */
    private TireNode root = new TireNode('/');

    public void insert(char[] wordArray) {
        TireNode p = root;
        int n = wordArray.length;
        for (char ch : wordArray) {
            int index = ch - 'a';
            if (p.children[index] == null) {
                TireNode newNode = new TireNode(ch);
                p.children[index] = newNode;
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    public boolean find(String s, int i) {
        if (i >= s.length()) {
            return true;
        }
        TireNode p = root;
        int n = s.length();
        for (; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            // 没有找到指定的字符,直接返回false
            if (p.children[index] == null) {
                return false;
            }
            // 接着往下一个开始找
            p = p.children[index];
            if (p.isEndingChar) {
                if (find(s, i + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
