package com.leetcode.test71;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Leiyi548
 * @package com.力扣.test71
 * @project leetcode
 * @created 2022/3/11 9:12 周五
 */
public class Test {
    public static void main(String[] args) {
        String path = "home/.config/nvim/../";
        String ans = new Solution().simplifyPath(path);
        System.out.println(ans);
    }
}


class Solution {
    public String simplifyPath(String path) {
        Deque<String> queue = new ArrayDeque<>();
        String[] strs = path.split("/");

        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals(".") || strs[i].equals(""))
                continue;
            else if (strs[i].equals("..")) {
                if (!queue.isEmpty())
                    queue.removeLast();
            } else
                queue.addLast(strs[i]);
        }
        if (queue.isEmpty()) return "/";
        // 默认构造函数构造出来的长度是16
        // 例如放的是home 那么就把h o m e对应的ASCII码放入StringBuilder的byte数组内
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty())
            sb.append(queue.removeFirst()).append("/");

        // 设置count的大小
        sb.setLength(sb.length() - 1);
        sb.insert(0, "/");
        // 来建立String(长度为count)
        return sb.toString();
    }
}

