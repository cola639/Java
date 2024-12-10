package org.example;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CGLIBProxyExample {

    public static void main(String[] args) {
        // 创建原始对象
        Main main = new Main();

        // 创建CGLIB代理
        Main proxy = (Main) Enhancer.create(Main.class, new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, java.lang.reflect.Method method, Object[] args, MethodProxy proxy) throws Throwable {
                System.out.println("CG Before method: " + method.getName());
                Object result = proxy.invokeSuper(obj, args); // 调用原始方法
                System.out.println("CG After method: " + method.getName());
                return result;
            }
        });

        // 调用代理方法
        proxy.sayHello();  // 调用实例方法
    }
}