package com.procon.netty.channel;

import com.procon.netty.utils.ByteBufferUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;



/**
 * <p>channel demo</p>
 *
 * @author procon
 * @since 2023年02月23日
 */
@Slf4j
public class ChannelDemo1 {
    public static void main(String[] args) {
        try(RandomAccessFile file = new RandomAccessFile("netty/src/main/resources/data.txt","rw")) {
            ByteBuffer buffer1 = StandardCharsets.UTF_8.encode("你好");


            ByteBufferUtil.debugAll(buffer1);


            CharBuffer buffer3 = StandardCharsets.UTF_8.decode(buffer1);
            log.info("{}",buffer3.getClass());
            log.info("{}",buffer3);
            FileChannel channel = file.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(20);
            do {
                // 向 buffer 写入
                int len = channel.read(buffer);
                log.debug("读到字节数：{}", len);
                if (len == -1) {
                    break;
                }
                // 切换 buffer 读模式
                buffer.flip();
                while(buffer.hasRemaining()) {
                    log.debug("{}", (char)buffer.get());
                }
                // 切换 buffer 写模式
                buffer.clear();
            } while (true);

        }catch (IOException e) {
            log.error("读取文件出现异常{}", e.getMessage());
        }
    }
}
