package cc.procon.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.Socket;

/**
 * <p>Selector客户端</p>
 *
 * @author procon
 * @since 2023/3/11
 */
@Slf4j
public class SelectorClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080)) {
            log.info("{}",socket);
            socket.getOutputStream().write("world".getBytes());
            int read = System.in.read();
            log.info("{}",read);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
