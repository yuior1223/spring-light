package beans.factory.support;

import beans.BeansException;
import beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 *
 * 实现createBean,但未实现getbeanDefinition
 * @author zyl
 * @date 2024/05/01
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();


    /**
     *
     * @param beanName
     * @param beanDefinition
     * @return {@link Object }
     * @throws BeansException
     */
    @Override
        protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
            return doCreateBean(beanName, beanDefinition);
        }

        protected Object doCreateBean(String beanName, BeanDefinition beanDefinition) {
            Object bean = creatBeanInstance(beanDefinition);

            addSingleton(beanName, bean);
            return bean;
        }
    public Object creatBeanInstance(BeanDefinition beanDefinition){
        return getInstantiationStrategy().instantite(beanDefinition);

        }


    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}

