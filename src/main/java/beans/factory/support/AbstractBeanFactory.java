package beans.factory.support;

import beans.BeansException;
import beans.factory.BeanFactory;
import beans.factory.config.BeanDefinition;

/**
 * 实现单例模式下的BeanFac
 * 根据beandef信息生成bean对象
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    /**
     * 有bean就直接取，没有就根据def创建一个
     *
     * @param name
     * @return {@link Object }
     * @throws BeansException
     */
    @Override
    public Object getBean(String name) throws BeansException {
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name,beanDefinition);

    }


    /**
     * 根据名字和定义创建Bean
     * @param beanName
     * @param beanDefinition
     * @return {@link Object }
     * @throws BeansException
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;

    protected abstract BeanDefinition getBeanDefinition(String beanName);
}
