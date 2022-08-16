package com.leetcode.test.stringbuffer;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/**
 * @author chris
 * @version V1.0
 * @package com.leetcode.test.stringbuffer
 * @date 2022/4/5 20:07
 */

public class SetTest {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add(new Employee("jack", 18));
        hashSet.add(new Employee("daisy", 18));
        hashSet.add(new Employee("leiyi", 18));
        System.out.println("hashSet->" + hashSet);
    }
}

class Employee {
    private String name;
    private int age;

    public Employee() {
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}