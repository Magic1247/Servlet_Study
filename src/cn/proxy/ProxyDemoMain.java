package cn.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyDemoMain {
    public static void main(String[] args) {
        SealComputerimpl sealimpl = new SealComputerimpl();
        // 创建动态代理对象newProxyInstance 传递真实对象的类加载器，真实对象所实现的接口及InvocationHandler对象
        SealComputer proxy_sealimpl = (SealComputer) Proxy.newProxyInstance(sealimpl.getClass().getClassLoader(), sealimpl.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (method.getName().equals("seal")) {  // 判断方法名称是否为seal
                            String invoke = (String) method.invoke(sealimpl, args); // 使用真实对象及传递进来的原参数调用方法
                            return "这是代理返回值";  // 返回自定义的返回值
                        }
                        String invoke = (String) method.invoke(sealimpl, args);
                        return invoke;
                    }
                }
        );
        System.out.println(proxy_sealimpl.seal(80.454));
    }
}

