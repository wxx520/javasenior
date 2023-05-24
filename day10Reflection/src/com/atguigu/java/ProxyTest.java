package com.atguigu.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理举例
 *
 * @author wxxstar
 * @create 2023-04-02 15:59
 */

interface Human {
    String getBelief();

    void eat(String food);
}

//被代理类
class SuperMan implements Human {

    @Override
    public String getBelief() {
        return "I believe I can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃 " + food);
    }
}

/**
 * 想要实现动态代理，需要解决的问题？
 * 问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象
 * 问题二：当通过代理的对象调用方法时，如何动态的去调用被代理类中的同名方法
 */
class ProxyFactory {
    /**
     * 调用此方法，返回一个代理类的对象，解决问题一
     *
     * @param obj
     * @return
     */
    public static Object getProxyInstance(Object obj) {
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}

class MyInvocationHandler implements InvocationHandler {

    private Object obj;//需要使用被代理类的对象进行赋值

    public void bind(Object obj) {
        this.obj = obj;
    }

    /**
     * 当我们通过代理类的对象，调用方法a时，就会自动的调用如下的方法：invoke()
     *
     * @param proxy  the proxy instance that the method was invoked on
     * @param method the {@code Method} instance corresponding to
     *               the interface method invoked on the proxy instance.  The declaring
     *               class of the {@code Method} object will be the interface that
     *               the method was declared in, which may be a superinterface of the
     *               proxy interface that the proxy class inherits the method through.
     * @param args   an array of objects containing the values of the
     *               arguments passed in the method invocation on the proxy instance,
     *               or {@code null} if interface method takes no arguments.
     *               Arguments of primitive types are wrapped in instances of the
     *               appropriate primitive wrapper class, such as
     *               {@code java.lang.Integer} or {@code java.lang.Boolean}.
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //method：即为代理类对象调用的方法，此时方法也就作为类被代理类对象要调用的方法
        HumanUtil humanUtil = new HumanUtil();
        humanUtil.m1();
        Object returnValue = method.invoke(obj, args);

        humanUtil.m2();
        return returnValue;
    }
}

class HumanUtil {
    public void m1() {
        System.out.println("通用方法111111");
    }

    public void m2() {
        System.out.println("通用方法222222");
    }
}

public class ProxyTest {
    public static void main(String[] args) throws NoSuchFieldException {
        SuperMan superMan = new SuperMan();
        //代理类的对象
        Object proxyInstanceObj = ProxyFactory.getProxyInstance(superMan);
        System.out.println(proxyInstanceObj.getClass().getCanonicalName());
        Human proxyInstance = (Human) proxyInstanceObj;
        proxyInstance.getBelief();
        proxyInstance.eat("四川麻辣烫");

        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ClothFactory proxyClothFactory = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);
        System.out.println(ProxyClothFactory.class.getDeclaredField("factory"));
        //说明代理并不是被代理类的实例，匿名接口实现类
        //System.out.println(proxyClothFactory.getClass().getDeclaredField("factory"));
        proxyClothFactory.produceCloth();
    }
}
