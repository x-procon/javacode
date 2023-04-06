package cc.procon.nio.channel;


import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * <p>客户端</p>
 *
 * @author procon
 * @since 2023年02月27日
 */
@Slf4j
public class SocketChannelClient {
    public static void main(String[] args) throws IOException {
        SocketChannel client = SocketChannel.open();
        client.connect(new InetSocketAddress(8080));
        client.write(Charset.defaultCharset().encode("hello"));
        log.info("waiting...");
    }
}
