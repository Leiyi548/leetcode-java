package com.leetcode.test49;

import java.util.*;

/**
 * @author chris
 * @version V1.0
 * @package com.leetcode.test49
 * @date 2022/4/2 20:29
 */

public class Test {
    public static void main(String[] args) {
        String[] stringArr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] testArr = {"cab", "tin", "pew", "duh", "may", "ill", "buy", "bar", "max", "doc"};
//        String[] stringArr = {""};
//        Solution solution = new Solution();
        Solution02 solution02 = new Solution02();
//        System.out.println(solution.groupAnagrams(testArr));
        System.out.println(solution02.groupAnagrams(testArr));
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}

class Solution02 {
    private List<List<String>> result = new ArrayList<List<String>>();

    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            }
            List<String> list = new ArrayList<String>();
            for (int j = i + 1; j < n; j++) {
                if (used[i]) {
                    continue;
                }
                if (equal(strs[i], strs[j])) {
                    list.add(strs[j]);
                    used[j] = true;
                }
            }
            list.add(strs[i]);
            used[i] = true;
            result.add(list);
        }
        return result;
    }

    public boolean equal(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        char[] charArr1 = s1.toCharArray();
        char[] charArr2 = s2.toCharArray();
        if (n1 != n2) {
            return false;
        }
        Arrays.sort(charArr1);
        Arrays.sort(charArr2);
        String newS1 = new String(charArr1);
        String newS2 = new String(charArr2);
        if (newS1.equals(newS2)) {
            return true;
        }
        return false;
    }
}
