package com.leetcode.test91;

/**
 * @author chris
 * @version V1.0
 * @package com.力扣.test91
 * @date 2022/3/26 14:16
 */

public class Test {
    public static void main(String[] args) {
        String s = "2022";
        Solution solution = new Solution();
        int ans = solution.numDecodings(s);
        System.out.println(ans);
    }
}

class Solution {
    public int numDecodings(String s) {
        return getAns(s, 0);
    }

    private int getAns(String s, int start) {
        //划分到了最后返回 1
        if (start == s.length()) {
            return 1;
        }
        //开头是 0,0 不对应任何字母，直接返回 0
        if (s.charAt(start) == '0') {
            return 0;
        }
        //得到第一种的划分的解码方式
        int ans1 = getAns(s, start + 1);
        int ans2 = 0;
        //判断前两个数字是不是小于等于 26 的
        if (start < s.length() - 1) {
            int ten = (s.charAt(start) - '0') * 10;
            int one = s.charAt(start + 1) - '0';
            if (ten + one <= 26) {
                ans2 = getAns(s, start + 2);
            }
        }
        return ans1 + ans2;
    }
}
