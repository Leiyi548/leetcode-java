package com.leetcode.test.Tire;

/**
 * @author chris
 * @version V1.0
 * @package com.leetcode.test.Tire
 * @date 2022/4/5 16:48
 */

public class Test {
    public static void main(String[] args) {
        String[] stringArray = {"inn", "int", "ate", "age", "adv", "ant"};
        Tire tire = new Tire();
        for (String s : stringArray) {
            tire.insert(s.toCharArray());
        }
    }
}
