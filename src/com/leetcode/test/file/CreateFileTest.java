package com.leetcode.test.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author chris
 * @version V1.0
 * @package com.leetcode.test.file
 * @date 2022/4/7 10:59
 */

public class CreateFileTest {
    public static void main(String[] args) {

    }

    @Test
    public void createFile01() {
        String filePath = "e:\\1.txt";
        File file = new File(filePath);
        try {
            file.createNewFile();
            System.out.println("文件创建成功!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createFile02() {
        File parentFile = new File("e:\\");
        String fileName = "2.txt";
        File file = new File(parentFile, fileName);
        try {
            file.createNewFile();
            System.out.println("文件创建成功!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createFile03() {
        String parentPath = "e:\\";
        String fileName = "3.txt";
        File file = new File(parentPath, fileName);
        try {
            file.createNewFile();
            System.out.println("文件创建成功!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void printInformation() {
        File file = new File("E:\\1.txt");
        System.out.println("文件名：" + file.getName());
        System.out.println("文件绝对路径：" + file.getAbsolutePath());
        System.out.println("文件父级目录：" + file.getParent());
        System.out.println("文件大小(字节)：" + file.length());
        System.out.println("文件是否存在：" + file.exists());
        System.out.println("是不是一个文件：" + file.isFile());
        System.out.println("是不是一个文件：" + file.isDirectory());
    }

    @Test
    public void readFile01() throws IOException {
        String filePath = "e:\\1.txt";
        int readData = 0;
        FileInputStream fileInputStream = null;
        try {
            //创建 FileInputStream 对象，用于读取 文件
            fileInputStream = new FileInputStream(filePath);
            //从该输入流读取一个字节的数据。 如果没有输入可用，此方法将阻止。
            //如果返回-1 , 表示读取完毕
            while ((readData = fileInputStream.read()) != -1) {
                System.out.print((char) readData);//转成 char 显示
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭文件流，释放资源.
            fileInputStream.close();
        }
    }
}
