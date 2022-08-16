package com.leetcode.test.stringbuffer;

import java.util.HashMap;
import java.util.Set;

/**
 * @author chris
 * @version V1.0
 * @package com.leetcode.test.stringbuffer
 * @date 2022/4/5 20:35
 */

public class MapExercise {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put(1, new People("hello", 19000));
        hashMap.put(2, new People("daisy", 21000));
        hashMap.put(3, new People("leiyi", 5000));

        Set keySet = hashMap.keySet();
        for (Object key : keySet) {
            People people = (People) hashMap.get(key);
            if (people.getSalary() > 18000) {
                System.out.println(people);
            }
        }
    }
}

class People {
    private String name;
    private double salary;

    public People(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
