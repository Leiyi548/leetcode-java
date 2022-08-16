package com.leetcode.test89;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chris
 * @version V1.0
 * @package com.力扣.test89
 * @date 2022/3/24 18:19
 */

public class Test {
    public static void main(String[] args) {
        System.out.println("hello,world");
    }

}

/**
 * 递归
 */
class Solution {
    private List<Integer> res = new ArrayList<>();

    public List<Integer> grayCode(int n) {
        dfs(n, new StringBuilder(), new int[]{0, 1});
        return res;
    }

    public void dfs(int n, StringBuilder sb, int[] nums) {
        //判断条件，是否返回
        if (sb.length() == n) {
            // 二进制转换为十进制
            res.add(Integer.valueOf(sb.toString(), 2));
            return;
        }
        //回溯第一个状态
        sb.append(nums[0]);
        //注意数组
        dfs(n, sb, new int[]{0, 1});
        sb.deleteCharAt(sb.length() - 1);
        // 回溯第二个状态
        sb.append(nums[1]);
        //注意数组
        dfs(n, sb, new int[]{1, 0});
        sb.deleteCharAt(sb.length() - 1);
    }
}
