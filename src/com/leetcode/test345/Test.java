package com.leetcode.test345;

import java.util.HashSet;

/**
 * 2022/4/17 10:52
 *
 * @author chris
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        String s = "leetcode";
        Solution solution = new Solution();
        System.out.println(solution.reverseVowels(s));
    }

    @org.junit.jupiter.api.Test
    public void example() {
        char ch = 'a';
        char CH = 'A';
        System.out.println("ch = " + ((int) ch));
        System.out.println("CH = " + ((int) CH));
        System.out.println(ch - ' ');
        System.out.println(CH - ' ');
    }
}

class Solution02 {
    static boolean[] hash = new boolean[128];
    static char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};

    static {
        for (char c : vowels) {
            hash[c - ' '] = hash[Character.toUpperCase(c) - ' '] = true;
        }
    }

    public String reverseVowels(String s) {
        char[] cs = s.toCharArray();
        int n = s.length();
        int l = 0, r = n - 1;
        while (l < r) {
            if (hash[cs[l] - ' '] && hash[cs[r] - ' ']) {
                swap(cs, l++, r--);
            } else {
                if (!hash[cs[l] - ' ']) {
                    l++;
                }
                if (!hash[cs[r] - ' ']) {
                    r--;
                }
            }
        }
        return String.valueOf(cs);
    }

    void swap(char[] cs, int l, int r) {
        char c = cs[l];
        cs[l] = cs[r];
        cs[r] = c;
    }
}

class Solution {
    public String reverseVowels(String s) {
        char[] charArr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        int n = s.length();
        if (n == 1) {
            return s;
        }
        int left = 0, right = n - 1;
        while (left < right) {
            while (!set.contains(s.charAt(left)) && left < right) {
                System.out.println("left = " + left);
                left++;
            }
            while (!set.contains(s.charAt(right)) && left < right) {
                System.out.println("right = " + right);
                right--;
            }
            swap(charArr, left, right);
            left++;
            right--;
        }
        for (char c : charArr) {
            sb.append(c);
        }
        return sb.toString();
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
