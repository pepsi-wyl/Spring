package daili;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author by pepsi-wyl
 * @date 2022-01-23 16:58
 */
public class JDKProxy {
    public static void main(String[] args) {
        UserDao proxy = new ProxyInvocationHandler().getProxy(UserDao.class, new UserDaoImpl());
        System.out.println(proxy.add(1, 2));
        System.out.println(proxy.update("10086"));
    }
}

class ProxyInvocationHandler {
    //生成代理类
    public <T> T getProxy(Class<T> t, Object implClass) {   // 实现类
        // newProxyInstance(
        // ClassLoader loader,     // 类加载器
        // Class<?>[] interfaces,  // 实现类的接口
        // InvocationHandler h     // InvocationHandler接口实例 invoke(Object proxy, Method method, Object[] args) 处理代理的实例
        // )
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), implClass.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println(method.getName() + "执行");
                    return method.invoke(implClass, args);
                }
        );
    }
}


