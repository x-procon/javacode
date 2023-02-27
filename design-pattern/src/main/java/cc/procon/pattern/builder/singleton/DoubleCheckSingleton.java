package cc.procon.pattern.builder.singleton;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * 恶汉式双重锁检测创建单例对象
 *
 * @author procon
 * @since 2023-02-14
 */
@Slf4j
public class DoubleCheckSingleton {
    /**
     *  私有构造方法
     */
    private DoubleCheckSingleton(){}
    /** 对外提供静态方法获取该对象 */
    public static volatile DoubleCheckSingleton instance;
    public static DoubleCheckSingleton getInstance(){
        if(Objects.isNull(instance)){
            synchronized(DoubleCheckSingleton.class){
                //抢到锁之后再次判断是否为空
                if(Objects.isNull(instance)){
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        DoubleCheckSingleton instance1 = DoubleCheckSingleton.getInstance();
        DoubleCheckSingleton instance2 = DoubleCheckSingleton.getInstance();
        log.info("{}",instance1 == instance2);
    }
}
