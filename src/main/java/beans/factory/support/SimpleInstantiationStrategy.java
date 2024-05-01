package beans.factory.support;

import beans.BeansException;
import beans.factory.config.BeanDefinition;

import java.lang.reflect.InvocationTargetException;

public class SimpleInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantite(BeanDefinition beanDefinition) throws BeansException {
        Class<?> beanClass = beanDefinition.getBeanClass();
        try {
            Object res = beanClass.getDeclaredConstructor().newInstance();
            return beanClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new BeansException("Failed to instantiate [" + beanClass.getName() + "]", e);
        }
    }
}
