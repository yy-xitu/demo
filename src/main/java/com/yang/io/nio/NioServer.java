package com.yang.io.nio;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @类编号
 * @类名称：NioServer
 * @文件路径; com.yang.io.nio.NioServer
 * @内容摘要： NIo 基本连接 数据读写  这种会遍历许多 空连接 即 如果有10w个链接 只有100个发送了数据
 *              效率差  优化 需要使用nio Selector 参照 NioSelectorServer
 * @编码作者：yang
 * @创建日期：2021/6/22 17:52
 * @version：code
 * @since：code
 * @commonents：
 */
public class NioServer {
    static List<SocketChannel> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        ServerSocketChannel src = ServerSocketChannel.open();//创建Nio ServerSocketChannel 类似BIO ServerSocket
        src.socket().bind(new InetSocketAddress(9000));//绑定端口
        src.configureBlocking(false);//设置为非阻塞，阻塞的话跟  BIO 差不多

        System.out.println("服务器启动成功");

        while (true){
            SocketChannel socketChannel = src.accept();//服务配置为非阻塞，这个地方如果没有客户端连接也不会阻塞
            if(socketChannel!=null){
                System.out.println("客户端连接成功");
                socketChannel.configureBlocking(false);//设置当前连接为非阻塞 没有数据读写也不会阻塞
                list.add(socketChannel);
            }

            Iterator<SocketChannel> iterator = list.iterator();
            while (iterator.hasNext()){
                SocketChannel channel = iterator.next();
                ByteBuffer buffer = ByteBuffer.allocate(128);
                int len = channel.read(buffer);//客户端断开连接时 len为-1需要将channel 从list中移除
                if(len>0){
                    System.out.println("接收到客户端消息"+new String(buffer.array()));
                }else if(len==-1){
                    iterator.remove();
                    System.out.println("客户端断开连接");
                }
            }
        }
    }

}
