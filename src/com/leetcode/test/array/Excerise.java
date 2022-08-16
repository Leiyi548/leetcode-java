package com.leetcode.test.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chris
 * @version V1.0
 * @package com.leetcode.test.array
 * @date 2022/4/3 10:39
 */

public class Excerise {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("红楼梦", 100);
        books[1] = new Book("金瓶梅新", 90);
        books[2] = new Book("青年文摘 20 年", 5);
        books[3] = new Book("java 从入门到放弃~", 300);
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                double priceGap = o2.getPrice() - o1.getPrice();
                if (priceGap > 0) {
                    return 1;
                } else if (priceGap < 0) {
                    return -1;
                }
                return 0;
            }
        });
        System.out.println(Arrays.toString(books));
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o2.getName().length() - o1.getName().length();
            }
        });
        System.out.println(Arrays.toString(books));
    }
}
