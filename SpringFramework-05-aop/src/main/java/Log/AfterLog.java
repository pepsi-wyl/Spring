package Log;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;

/**
 * @author by wyl
 * @date 2021/9/25.21点13分
 */

@Component
@Scope("singleton")
public class AfterLog implements AfterReturningAdvice {
    /**
     * @param returnValue 返回值
     * @param method      要执行的目标对象的方法
     * @param args        方法的参数
     * @param target      目标对象
     * @throws Throwable
     */
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("[DEBUG]" + target.getClass().getName() + "的" + method.getName() + "执行完毕" + (returnValue == null ? "" : "返回值为" + returnValue));
    }
}
