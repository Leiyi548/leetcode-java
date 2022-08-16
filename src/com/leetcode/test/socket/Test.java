package com.leetcode.test.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author chris
 * @version V1.0
 * @package com.leetcode.test.socket
 * @date 2022/4/7 12:52
 */

public class Test {
    @org.junit.jupiter.api.Test
    public void server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端，在 9999 端口监听，等待连接..");
        Socket socket = serverSocket.accept();
        System.out.println("服务端 socket =" + socket.getClass());
        //3. 通过 socket.getInputStream() 读取客户端写入到数据通道的数据, 显示
        InputStream inputStream = socket.getInputStream();
        //4. IO 读取
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1) {
            //根据读取到的实际长度，显示内容.
            System.out.println(new String(buf, 0, readLen));
        }
        //5. 获取 socket 相关联的输出流
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello, client".getBytes());
        // 设置结束标记
        socket.shutdownOutput();
        //6.关闭流和 socket
        outputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();//关闭
    }

    @org.junit.jupiter.api.Test
    public void client() throws IOException {
        //1. 连接服务端 (ip , 端口）
        //解读: 连接本机的 9999 端口, 如果连接成功，返回 Socket 对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 socket 返回=" + socket.getClass());
        //2. 连接上后，生成 Socket, 通过 socket.getOutputStream()
        // 得到 和 socket 对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        //3. 通过输出流，写入数据到 数据通道
        outputStream.write("hello, server".getBytes());
        // 设置结束标记
        socket.shutdownOutput();
        //4. 获取和 socket 关联的输入流. 读取数据(字节)，并显示
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf, 0, readLen));
        }
        //5. 关闭流对象和 socket, 必须关闭
        inputStream.close();
        outputStream.close();
        socket.close();
        System.out.println("客户端退出.....");
    }
}
