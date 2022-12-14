package cc.procon.classloader;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>classLoaderTest</p>
 *
 * @author Procon
 * @version v1.0
 * @since 2022/6/29
 */
@Slf4j
public class ClassLoaderTest  {
    public static void main(String[] args) {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        //sun.misc.Launcher$AppClassLoader@18b4aac2
        log.info("系统类加载器内存地址:{}",systemClassLoader);
        //sun.misc.Launcher$ExtClassLoader@5fdef03a
        ClassLoader extClassLoader = systemClassLoader.getParent();
        log.info("扩展类加载器内存地址:{}",extClassLoader);
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        //null
        log.info("引导类加载器内存地址:{}",bootstrapClassLoader);
    }
}
