import bean.Person;
import beans.factory.PropertyValue;
import beans.factory.PropertyValues;
import beans.factory.config.BeanDefinition;
import beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestPopulateWithPropertites {
    @Test
    public void testPopulateBeanWithPropertyValues() throws Exception {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("name", "derek"));
        propertyValues.addPropertyValue(new PropertyValue("age", 18));
        BeanDefinition beanDefinition = new BeanDefinition(Person.class, propertyValues);
        beanFactory.registerBeanDefinition("person", beanDefinition);

        Person person = (Person) beanFactory.getBean("person");
        System.out.println(person);
        assertThat(person.getName()).isEqualTo("derek");
        assertThat(person.getAge()).isEqualTo(18);
    }
}
