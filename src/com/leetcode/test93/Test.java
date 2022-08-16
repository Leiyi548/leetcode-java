package com.leetcode.test93;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author chris
 * @version V1.0
 * @package com.leetcode.test93
 * @date 2022/4/3 10:18
 */

public class Test {
    public static void main(String[] args) {
        String s = "25525511135";
        Solution solution = new Solution();
        System.out.println(solution.restoreIpAddresses(s));
    }
}


class Solution {
    //画图理解
    public List<String> restoreIpAddresses(String s) {
        //定义表示一个字符长度的变量
        int len = s.length();
        //定义一个返回结果的集合
        List<String> res = new ArrayList<>();
        //如果当前字符长度大于12或者小于4都不满足
        // 255转换为二进制就为 0001 0000 0000
        if (len > 12 || len < 4) {
            return res;
        }
        //定义一个保存路径上的变量
        Deque<String> path = new ArrayDeque<>();
        //深度优先搜索
        dfs(s, len, 0, 4, path, res);
        //返回结果
        return res;
    }

    public void dfs(String s, int len, int begin, int residue, Deque<String> path, List<String> res) {
        //如果字符串已经遍历到最后了，并且已经切分为4段了，
        //就把当前路径上的元素加入到返回的结果集中
        if (begin == len) {
            if (residue == 0) {
                res.add(String.join(".", path));
            }
            return;
        }
        //begin表示遍历字符串从哪里开始
        for (int i = begin; i < begin + 3; i++) {
            //如果超出字符串的长度，就直接退出
            //begin，每次选择都是从之前选择的元素的下一个元素开始，
            if (i >= len) {
                break;
            }
            //如果剩余元素大于ip最多能容纳的个数，就剪枝。
            if (len - i > residue * 3) {
                continue;
            }
            //判断当前截取字符是否是小于0或者大于255
            //这里的begin和i，代表的是，这时候截取了几个字符
            //begin从哪里开始，i到哪里结束
            if (judgeIpSegment(s, begin, i)) {
                //保留当前截取字符
                String currentIpSegment = s.substring(begin, i + 1);
                //将当前路径上的元素加入到路径队列中
                path.addLast(currentIpSegment);
                //递归下一层
                dfs(s, len, i + 1, residue - 1, path, res);
                //剪枝
                path.removeLast();
            }
        }
    }

    private boolean judgeIpSegment(String s, int left, int right) {
        //定义一个表示整个字符的长度
        int len = right - left + 1;
        //如果截取的大于等于2的字符的开头为0，就直接false
        if (len > 1 && s.charAt(left) == '0') {
            return false;
        }
        //定义返回结果的集合
        int res = 0;
        //拼接字符
        while (left <= right) {
            //res*10 是为了将先加的字符默认比后面的字符大10倍，也就是位数是从小到大
            res = res * 10 + s.charAt(left) - '0';
            left++;
        }
        return res >= 0 && res <= 255;
    }
}
