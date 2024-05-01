package beans.factory.support;

import beans.BeansException;
import beans.factory.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantite(BeanDefinition beanDefinition) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        MethodInterceptor methodInterceptor = (obj, method, argsTemp, proxy) -> {
            System.out.println("代理方法创建");
            return proxy.invokeSuper(obj,argsTemp);};
        enhancer.setCallback(methodInterceptor);

        return enhancer.create();
    }
}
