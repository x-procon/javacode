package cc.procon.classloader;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>自定义类加载器</p>
 *
 * @author Procon
 * @version v1.0
 * @since 2022/6/29
 */
@Slf4j
@SuppressWarnings("unused")
public class CustomerClassLoader extends ClassLoader{

    @Override
    protected Class<?> findClass(String name) {
        byte[] result = getClassFromCustomerPath(name);
        return defineClass(name,result,0,result.length);
    }

    @SuppressWarnings("unused")
    private byte[] getClassFromCustomerPath(String name){
       // 从自定义路径中加载类
        return new  byte[1024];
    }
}
