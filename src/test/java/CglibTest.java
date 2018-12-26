import cglib.Book;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;

import java.lang.reflect.Method;

public class CglibTest {

    @Test
    public void testCglib() {
        // 委托对象
        Book book = new Book();
        // 获取动态代理对象
        Book bookProxy = (Book)Enhancer.create(book.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object result = null;
                // 在原有业务逻辑之前增强
                System.out.println("执行之前增强");
                // 调用原有业务逻辑
                result = method.invoke(book,objects);
                // 在原有业务逻辑之后增强
                System.out.println("执行之后增强");
                return result;
            }
        });

        bookProxy.addBook();
    }
}
