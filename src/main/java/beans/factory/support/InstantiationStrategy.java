package beans.factory.support;

import beans.BeansException;
import beans.factory.config.BeanDefinition;

public interface InstantiationStrategy {
    Object instantite(BeanDefinition beanDefinition) throws BeansException;
}
