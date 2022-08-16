package com.leetcode.test.Tire;

/**
 * @author chris
 * @version V1.0
 * @package com.leetcode.test.Tire
 * @date 2022/4/5 16:26
 */

public class TireNode {
    public char data;
    public TireNode[] children = new TireNode[26];
    public boolean isEndingChar = false;

    public TireNode(char data) {
        this.data = data;

    }
}
