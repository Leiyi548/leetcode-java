package com.leetcode.test.generic;

/**
 * @author chris
 * @version V1.0
 * @package com.leetcode.test.generic
 * @date 2022/4/6 0:23
 */

public class Test {
    public static void main(String[] args) {
        Person<String> person = new Person<String>("韩顺平教育");
        person.show(); //String
    }
}

class Person<E> {
    E s;

    public Person(E s) {//E 也可以是参数类型
        this.s = s;
    }

    public E f() {//返回类型使用 E
        return s;
    }

    public void show() {
        System.out.println(s.getClass());//显示 s 的运行类型
    }

}
