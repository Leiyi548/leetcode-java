package com.leetcode.test.wrapper;

/**
 * Created by IntelliJ IDEA.
 *
 * @author chris
 * @version 1.0
 * @created 2022/4/12 11:16
 */
public class EnumTest {
    public static void main(String[] args) {
        // compare To
        Season spring = Season.SPRING;
        Season summer = Season.SUMMER;
        System.out.println(spring.getClass());
        System.out.println(summer.getClass());
        System.out.println(spring.getDeclaringClass());
        System.out.println(summer.getDeclaringClass());
        System.out.println(Season.SPRING.compareTo(Season.SUMMER));
    }
}

enum Season {
    SPRING("春天", "温暖"),
    SUMMER("夏天", "炎热"),
    AUTUMN("秋天", "舒适"),
    WINTER("冬天", "寒冷");
    private String name;
    private String description;

    Season() {
    }

    Season(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
