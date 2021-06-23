package com.yang.io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @类编号
 * @类名称：SocketClient
 * @文件路径; com.yang.io.bio.SocketClient
 * @内容摘要：
 * @编码作者：yang
 * @创建日期：2021/6/22 10:45
 * @version：code
 * @since：code
 * @commonents：
 */
public class SocketClient {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(9000);//创建一个服务端  端口9000
        while (true){
            System.out.println("等待连接中");
            Socket accept = socket.accept();
            System.out.println("客户端连接成功");
            handel(accept);
        }
    }
    private static void handel(Socket accept) throws IOException {
        byte[] bytes = new byte[1024];
        //接收客户端数据 阻塞方法，没有数据可读时就阻塞
        int read = accept.getInputStream().read(bytes);
        System.out.println("读取完毕");
        if(read!=-1){
            System.out.println("接收到客户端的数据"+new String(bytes,0,read));
        }
    }
}
