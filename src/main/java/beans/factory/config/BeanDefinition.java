package beans.factory.config;


import beans.factory.PropertyValues;

/**
 * class类型、方法构造参数、是否为单例等，此处简化只包含class类型 properties 属性
 * @author zyl
 * @date 2024/05/01
 */
public class BeanDefinition {
    private Class beanClass;

    private PropertyValues propertyValues;

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues;
    }

    public BeanDefinition(Class beanClass){
        this.beanClass = beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
