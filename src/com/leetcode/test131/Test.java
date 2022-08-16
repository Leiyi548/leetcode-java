package com.leetcode.test131;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chris
 * @version V1.0
 * @package com.leetcode.test131
 * @date 2022/4/5 9:14
 */

public class Test {
    public static void main(String[] args) {
        String s = "aab";
        Solution solution = new Solution();
        System.out.println(solution.partition(s));
    }
}

class Solution {
    private List<List<String>> result = new ArrayList<List<String>>();

    public List<List<String>> partition(String s) {
        backstrack(s, 0, new ArrayList<>());
        return result;
    }

    public void backstrack(String s, int index, List<String> path) {
        if (index == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = index + 1; i <= s.length(); i++) {
            String subString = s.substring(index, i);

            if (isPalindrome(subString)) {
                path.add(subString);
                backstrack(s, i, path);
                path.remove(path.size() - 1);
            }

        }
    }

    public boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}