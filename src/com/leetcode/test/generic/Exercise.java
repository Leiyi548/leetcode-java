package com.leetcode.test.generic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author chris
 * @version V1.0
 * @package com.leetcode.test.generic
 * @date 2022/4/6 16:04
 */

public class Exercise {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("金木研", "51000", new MyDate(2001, 3, 3)));
        list.add(new Employee("路飞君", "18000", new MyDate(2001, 3, 3)));
        list.add(new Employee("鸣人22", "21000", new MyDate(1988, 8, 8)));
        list.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                int i = o1.compareTo(o2);
                if (i != 0) {
                    return i;
                }
                return o1.getBirthDate().compareTo(o2.getBirthDate());
            }
        });
        System.out.println(list);
    }
}


class Employee {
    private String name;
    private String sal;
    private MyDate birthDate;

    public Employee(String name, String sal, MyDate birthDate) {
        this.name = name;
        this.sal = sal;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public String getSal() {
        return sal;
    }

    public MyDate getBirthDate() {
        return birthDate;
    }

    public int compareTo(Employee newEmp) {
        if (this.name.length() == newEmp.name.length()) {
            return 0;
        } else if (newEmp.name.length() > this.name.length()) {
            return 1;
        } else {
            return -1;
        }


    }

    @Override
    public String toString() {
        return "Employee{" + "name='" + name + '\'' + ", sal='" + sal + '\'' + ", birthDate=" + birthDate + '}';
    }
}

class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" + "year=" + year + ", month=" + month + ", day=" + day + '}';
    }

    public int compareTo(MyDate newDate) {
//        if (this.year == newDate.year && this.month == newDate.month && this.day == newDate.day) {
//            return 0;
//        }
        if (newDate.year > this.year) {
            return 1;
        } else if (newDate.month == this.month) {
            if (newDate.day > newDate.day) {
                return 1;
            } else if (newDate.day < newDate.day) {
                return -1;
            } else {
                return 0;
            }
        } else {
            return -1;
        }
    }
}
