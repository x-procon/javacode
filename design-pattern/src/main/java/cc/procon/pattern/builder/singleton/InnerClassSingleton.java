package cc.procon.pattern.builder.singleton;

/**
 * 静态内部类创建单例对象
 *
 * @author procon
 * @since 2023-02-14
 */
public class InnerClassSingleton {



    private InnerClassSingleton() {}

    private static class SingletonHolder{
        private static final  InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
