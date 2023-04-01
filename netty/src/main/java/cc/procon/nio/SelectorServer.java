package cc.procon.nio;


import cc.procon.utils.ByteBufferUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

@Slf4j
public class SelectorServer {
    public static void main(String[] args) {
        try ( ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();){
            serverSocketChannel.bind(new InetSocketAddress(8080));
            //绑定 Channel 事件 也称之为注册事件，绑定的事件 selector 才会关心
            serverSocketChannel.configureBlocking(false);
            Selector selector = Selector.open();

            SelectionKey selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            log.debug("注册key:{}",selectionKey);
            while (true){
                int count = selector.select();
                log.debug("select count:{}",count);
                //获取所有的事件
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> iter = keys.iterator();
                if(iter.hasNext()){
                    SelectionKey key = iter.next();
                    if(key.isAcceptable()){
                        ServerSocketChannel c = (ServerSocketChannel) key.channel();
                        SocketChannel accept = c.accept();
                        log.debug("{}\n",accept);
                    }else if (key.isReadable()) {
                        SocketChannel sc = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(128);
                        int read = sc.read(buffer);
                        if(read == -1) {
                            key.cancel();
                            sc.close();
                        } else {
                            buffer.flip();
                           ByteBufferUtil.debugAll(buffer);
                        }
                    }
                    //处理完毕需要移除事件
                    iter.remove();
                }
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }
}
