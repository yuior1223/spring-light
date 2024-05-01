package beans.factory.support;

import beans.BeansException;
import beans.factory.config.BeanDefinition;

/**
 *
 * 实现createBean,但未实现getbeanDefinition
 * @author zyl
 * @date 2024/05/01
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {


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
            Class beanClass = beanDefinition.getBeanClass();
            Object bean = null;
            try {
                bean = beanClass.newInstance();
            } catch (Exception e) {
                throw new BeansException("Instantiation of bean failed", e);
            }

            addSingleton(beanName, bean);
            return bean;
        }
    }

