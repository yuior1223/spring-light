package beans.factory.support;

import beans.BeansException;
import beans.factory.PropertyValue;
import beans.factory.config.BeanDefinition;
import beans.factory.config.BeanReference;
import cn.hutool.core.bean.BeanUtil;

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

    /**
     * 实例化bean对象并为其中的属性赋值
     * @param beanName
     * @param beanDefinition
     * @return {@link Object }
     */
    protected Object doCreateBean(String beanName, BeanDefinition beanDefinition) {

            Object bean = null;
            try{
                bean = createBeanInstance(beanDefinition);
                applyPropertyValues(beanName, bean, beanDefinition);
            }
            catch (Exception e) {
                throw new BeansException("Instantiation of bean failed", e);
            }


            addSingleton(beanName, bean);
            return bean;
        }

    /**
     * 为bean填充属性
     * @param beanName
     * @param bean
     * @param beanDefinition
     */
    private void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            for(PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()){
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                if (value instanceof BeanReference) {
                    // beanA依赖beanB，先实例化beanB
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }

                //通过反射设置属性
                BeanUtil.setFieldValue(bean, name, value);
            }
        }
        catch (Exception ex){
        throw new BeansException("Error setting property values for bean: " + beanName, ex);
        }
    }

    public Object createBeanInstance(BeanDefinition beanDefinition){
        return getInstantiationStrategy().instantite(beanDefinition);

        }


    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}

