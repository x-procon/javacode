package cc.procon.nio.channel;

import cc.procon.utils.ByteBufferUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>socket channel 服务端</p>
 *
 * @author procon
 * @since 2023年02月27日
 */
@Slf4j
public class SocketChannelServer {
    public static void main(String[] args) throws IOException {
    // 使用 nio 来理解非阻塞模式, 单线程
    // 0. ByteBuffer
        ByteBuffer buffer = ByteBuffer.allocate(16);
    // 1. 创建了服务器
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);
    // 2. 绑定监听端口
        ssc.bind(new InetSocketAddress(8080));
        // 3. 连接集合
        List<SocketChannel> channels = new ArrayList<>();
        while (true) {
            // 4. accept 建立与客户端连接， SocketChannel 用来与客户端之间通信
            SocketChannel sc = ssc.accept();
            if (sc != null) {
                log.debug("connected... {}", sc);
                // 非阻塞模式
                sc.configureBlocking(false);
                channels.add(sc);
            }
            for (SocketChannel channel : channels) {
                // 5. 接收客户端发送的数据
                // 非阻塞，线程仍然会继续运行，如果没有读到数据，read 返回 0
                int read = channel.read(buffer);
                if (read > 0) {
                    buffer.flip();
                    ByteBufferUtil.debugRead(buffer);
                    buffer.clear();
                    log.debug("after read...{}", channel);
                }
            }
        }
    }

}
