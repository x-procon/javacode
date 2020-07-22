package com.hazer.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description: </br>
 * @author: Hazer
 * @date: 2020-06-29 15:56
 */
public class ProxyHandler implements InvocationHandler {
    //被代理的接口
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    /**
     * @description: 生成得到代理类
     * @param: []
     * @return: java.lang.Object
     */
    public Object getProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),this);
    }
    /**
     * @description: 处理代理实例并返回结果
     * @param: [proxy, method, args]
     * @return: java.lang.Object
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result =  method.invoke(target,args);
        return result;
    }
}
