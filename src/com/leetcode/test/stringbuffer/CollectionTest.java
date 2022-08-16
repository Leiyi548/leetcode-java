package com.leetcode.test.stringbuffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * @author chris
 * @version V1.0
 * @package com.leetcode.test.stringbuffer
 * @date 2022/4/5 20:52
 */

@SuppressWarnings("all")
public class CollectionTest {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (Integer) o2 - (Integer) o1;
            }
        });
        System.out.println(list);
        Collections.swap(list, 1, 2);
        System.out.println(list);
        System.out.println(Collections.max(list));
        System.out.println(Collections.frequency(list, 1));
    }
}
