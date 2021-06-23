package com.yang.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.Set;

/**
 * @类编号
 * @类名称：NioSelectorServer
 * @文件路径; com.yang.io.nio.NioSelectorServer
 * @内容摘要： Nio 复路器 进行筛选 有读写的连接  添加selector   selector 会监控连接，只处理哪些有操作的请求  linux实现是 epoll
 * @编码作者：yang
 * @创建日期：2021/6/23 9:57
 * @version：code
 * @since：code
 * @commonents：
 */
public class NioSelectorServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel src = ServerSocketChannel.open();//创建Nio ServerSocketChannel 类似BIO ServerSocket
        src.socket().bind(new InetSocketAddress(9000));//绑定端口
        src.configureBlocking(false);//设置为非阻塞，阻塞的话跟  BIO 差不多

        //打开Selector 处理Channel 即创建 epoll  epoll 在linux系统上有，windows系统是没有的
        Selector selector = Selector.open();

        //把ServerSocketChannel 注册到 selector上去 并且让selector对客户端注册 accept操作感兴趣
        src.register(selector, SelectionKey.OP_ACCEPT);

        while (true){
            //阻塞等待需要处理的事件发生
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();//获取 selector上注册的selectionKeys
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();

                if(key.isAcceptable()){//代表是链接操作
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();//
                    SocketChannel socketChannel = server.accept();//获取客户端连接
                    socketChannel.configureBlocking(false);//设置非阻塞
                    //将客户端 socketChannel连接注册到selector上
                    socketChannel.register(selector,SelectionKey.OP_READ);//关注读操作
                    System.out.println("客户端连接成功");
                }else if(key.isReadable()){
                    SocketChannel socketChannel = (SocketChannel) key.channel();//根据selectionKey获取连接
                    ByteBuffer buffer = ByteBuffer.allocate(128);
                    int len = socketChannel.read(buffer);//读取客户端发送过来的数据
                    if(len>0){
                        System.out.println("客户端发送的数据："+ new String(buffer.array()));
                    }else if(len==-1){//如果客户端断开连接 关闭连接channel
                        System.out.println("客户端断开连接");
                        socketChannel.close();
                    }
                }
                iterator.remove();//移除处理过的selectionKey
            }
        }
    }
}
