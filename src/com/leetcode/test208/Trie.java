package com.leetcode.test208;

import java.util.HashMap;

/**
 * 2022/4/28 16:00
 *
 * @author chris
 * @version 1.0
 */


class TrieNode {
    boolean isWord;//是否是单词
    TrieNode[] children;//26个小写字母

    public TrieNode() {
        isWord = true;
        children = new TrieNode[26];
    }
}

public class Trie {
    //根节点，根节点是不存储任何字母的，从根节点的
    //子节点开始存储
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    //插入字符串
    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            //判断字符有没有创建，如果没有创建就创建
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
                //中间的字符不是完整的单词
                current.children[index].isWord = false;
            }
            current = current.children[index];
        }
        //最后一个字符才能构成一个完整的单词
        current.isWord = true;
    }

    public boolean search(String word) {
        TrieNode current = find(word);
        return current != null && current.isWord;
    }

    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }

    private TrieNode find(String str) {
        // 从根节点开始搜索
        TrieNode current = root;
        int length = str.length();
        for (int i = 0; i < length; i++) {
            int index = str.charAt(i) - 'a';
            if ((current = current.children[index]) == null) {
                return null;
            }
        }
        return current;
    }
}