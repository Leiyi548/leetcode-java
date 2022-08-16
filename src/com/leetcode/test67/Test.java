package com.leetcode.test67;

/**
 * @author Leiyi548
 * @package com.力扣.test67
 * @project leetcode
 * @created 2022/3/6 10:36 周日
 */
public class Test {
    public static void main(String[] args) {
        String a = "1010", b = "1011";
        System.out.println(new Solution().addBinary(a, b));
    }
}

class Solution {
    public String addBinary(String a, String b) {
        // 数组是从0开始的，所以要-1
        int i = a.length() - 1;
        int j = b.length() - 1;
        // 记录进位
        int carry = 0;
        // 这个StringBuilder这个类可以建立追加字符串
        StringBuilder builder = new StringBuilder();
        //循环相加两个字符串相同长度的低位数部分
        while (i >= 0 && j >= 0) {
            // 加上进位
            int sum = carry;
            // 获得两个数字最后一位数字
            sum += a.charAt(i--) - '0';
            sum += b.charAt(j--) - '0';
            // 判断是否进位
            carry = sum / 2;
            // 添加进结果中
            builder.append(sum % 2);
        }
        // 如果 a 还没遍历完成（a串比b串长），则继续遍历添加 a 的剩余部分
        while (i >= 0) {
            int sum = carry + a.charAt(i--) - '0';
            carry = sum / 2;
            builder.append(sum % 2);
        }
        // 如果 b 还没遍历完成（b串比a串长），则继续遍历添加 b 的剩余部分
        while (j >= 0) {
            int sum = carry + b.charAt(j--) - '0';
            carry = sum / 2;
            builder.append(sum % 2);
        }
        //如果 carry 不等于0 还有个进位数没加进去，需要补充
        if (carry == 1) {
            builder.append(carry);
        }
        //反转字符串获得正常结果
        // 因为StringBuilder添加是往后加的,所以得到结果后面要逆转
        return builder.reverse().toString();
    }
}