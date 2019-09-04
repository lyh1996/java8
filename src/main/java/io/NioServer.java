package io;

import RequestHandler.RequestHandler;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author 633805 LYH
 * @version V1.0
 * @description 对类的描述
 * @create 2019-08-09 16:47
 * @since 1.7
 */
public class NioServer {
    public static void main(String[] args) throws Exception{
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        // Channel 通道  多路复用技术
        // 配置非阻塞
        socketChannel.configureBlocking(false);
        socketChannel.bind(new InetSocketAddress(9999));
        System.out.println("NIO NIOServer has start  :"+socketChannel.getLocalAddress());
        Selector selector = Selector.open();
        // 注册到选择器中   一旦有连接初始状态就是accept
        socketChannel.register(selector, SelectionKey.OP_ACCEPT);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // buffer 数据交互的桥梁
        RequestHandler requestHandler = new RequestHandler();

        // 不断循环监听channel状态的改变  accept   Read   write
        while (true) {
            // 轮询连接的时候会进行阻塞   和之前accept一样
            // select  使用Reactor模型   采用线程处理
            int select = selector.select();
            if (select == 0) {
                continue;
            }
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            //
            Iterator<SelectionKey> iterable = selectionKeys.iterator();
            while (iterable.hasNext()) {
                // SelectionKey
                SelectionKey key = (SelectionKey) ((Iterator) iterable).next();
                if (key.isAcceptable()) {
                    ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                    SocketChannel clientChannel = channel.accept();
                    System.out.println("Connection from " + clientChannel.getRemoteAddress());
                    clientChannel.configureBlocking(false);

                    // 通过redister改变channel要进行的操作
                    clientChannel.register(selector, SelectionKey.OP_READ);
                }
                if (key.isReadable()) {
                    // 所以采用多线程处理   主要是为了提高CPU利用率
                    SocketChannel channel = (SocketChannel) key.channel();
                    channel.read(buffer);
                    // buffer 中有个flip方法 用来清空
                    String request = new String(buffer.array()).trim();
                    buffer.clear();
                    System.out.println(String.format("From %s : %s", channel.getRemoteAddress(), request));
                    // 如果要处理几十秒
                    String response = requestHandler.handle(request);
                    channel.write(ByteBuffer.wrap(response.getBytes()));
                }
                iterable.remove();
            }
        }
    }
}
