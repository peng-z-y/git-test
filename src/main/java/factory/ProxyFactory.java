package factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    /**
     * 动态获取委托对象的代理对象
     * @param obj   委托对象
     * @return
     */
    public static Object getProxy(Object obj) {
        // 获取动态代理对象
        return Proxy.newProxyInstance(ProxyFactory.class.getClassLoader(), obj.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = null;


                // 分别当前动态调用的是哪个接口的哪个方法
                // 获取当前method所属的接口类路径
                String className = method.getDeclaringClass().getName();
                // 获取当前调用执行的方法名
                String methodName = method.getName();

                if("buyHouse.IBuyHouse".equalsIgnoreCase(className)) {
                    if("buyHouse".equalsIgnoreCase(methodName)) {
                        //  说明当前调用的是买房buyHouse这个接口方法
                        System.out.println("我是房屋中介，请支付服务费3000元");
                        result = method.invoke(obj,args);
                        System.out.println("出卖委托人信息到互联网，卖了三分钱");
                    }
                }

                if("findWife.IFindWife".equalsIgnoreCase(className)) {
                    if("findWife".equalsIgnoreCase(methodName)) {
                        System.out.println("婚姻中介，请支付服务费2000");
                        result = method.invoke(obj,args);
                        System.out.println("出卖夫妻双方信息到互联网");
                    }
                }

                return result;
            }
        });
    }

    /**
     * 只有接口类，没有实现类，返回代理对象完成功能
     * @param intf  接口类
     * @return
     */
    public static Object getProxyOnlyInterface(Class intf) {
        return Proxy.newProxyInstance(ProxyFactory.class.getClassLoader(), new Class[]{intf}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                Object result = null;
                String className = method.getDeclaringClass().getName();
                String methodName = method.getName();

                if("buyHouse.IBuyHouse".equalsIgnoreCase(className)) {
                    if("buyHouse".equalsIgnoreCase(methodName)) {
                        //  说明当前调用的是买房buyHouse这个接口方法
                        System.out.println("我是房屋中介，请支付服务费3000元");
                        System.out.println("步骤一：找房源");
                        System.out.println("步骤二：谈判");
                        System.out.println("步骤三：过户办理");
                        System.out.println("出卖委托人信息到互联网，卖了三分钱");
                    }
                }

                if("findWife.IFindWife".equalsIgnoreCase(className)) {
                    if("findWife".equalsIgnoreCase(methodName)) {
                        System.out.println("婚姻中介，请支付服务费2000");
                        System.out.println("相亲、网恋等");
                        System.out.println("温文尔雅");
                        System.out.println("出卖夫妻双方信息到互联网");
                    }
                }

                return result;
            }
        });
    }
}
