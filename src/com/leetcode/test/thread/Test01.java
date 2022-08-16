package com.leetcode.test.thread;

/**
 * @author chris
 * @version V1.0
 * @package com.leetcode.test.thread
 * @date 2022/4/7 10:42
 */

public class Test01 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.start();
        cat.run();
    }
}

class Cat extends Thread {
    int times = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("喵喵" + "我是一只小猫咪" + (++times) + "线程名=" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (times == 80) {
                break;
            }
        }
    }
}