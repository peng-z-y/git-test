import buyHouse.BuyHouseDelegation;
import buyHouse.IBuyHouse;
import factory.ProxyFactory;
import org.junit.Test;

public class MainTest {

    /**
     * 委托人自己做这件事
     */
    @Test
    public void testDoMyself() {
        IBuyHouse iBuyHouse = new BuyHouseDelegation();
        iBuyHouse.buyHouse();
    }

/*

    *//**
     * 找代理人做这件事
     *//*
    @Test
    public void testDoProxy() {
        // 委托人
        IBuyHouse iBuyHouse = new BuyHouseDelegation();
        // 代理人
        BuyHouseProxy iBuyHouseProxy = new BuyHouseProxy();
        // 委托人找到代理人
        iBuyHouseProxy.setBuyHouseDelegation(iBuyHouse);
        // 调用代理人的接口(代理人出面，委托人在后台不用出面)
        iBuyHouseProxy.buyHouse();
    }






    *//**
     * 使用动态代理技术获取代理对象
     *//*
    @Test
    public void testDynamicProxy() {
        // 委托人
        IBuyHouse iBuyHouse = new BuyHouseDelegation();

        // 获取动态代理对象
        IBuyHouse proxyObj = (IBuyHouse)Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{IBuyHouse.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = null;

                System.out.println("支付服务费200");

                // 执行正常的业务逻辑（委托人的业务逻辑）
                result = method.invoke(iBuyHouse,args);

                System.out.println("出卖个人信息");

                return result;
            }
        });


        proxyObj.buyHouse();
    }*/




    @Test
    public void testProxyFactory() {
        // 买房业务
        IBuyHouse iBuyHouse = new BuyHouseDelegation();
        // 获取动态代理对象
        IBuyHouse buyHouseProxy = (IBuyHouse) ProxyFactory.getProxy(iBuyHouse);
        buyHouseProxy.buyHouse();
    }




    @Test
    public void testProxyFactoryOnlyInterface() {
        // 买房业务
        IBuyHouse proxyOnlyInterface = (IBuyHouse) ProxyFactory.getProxyOnlyInterface(IBuyHouse.class);
        proxyOnlyInterface.buyHouse();
    }

}
