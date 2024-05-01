import beans.factory.config.BeanDefinition;
import beans.factory.support.CglibSubclassingInstantiationStrategy;
import beans.factory.support.DefaultListableBeanFactory;
import beans.factory.support.DefaultSingletonBeanRegistry;
import org.junit.Test;

public class TestBeanInsStrategy {
    @Test
    public void testStrategy() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinition HelloBeanDefinition = new BeanDefinition(HelloService.class);
        beanFactory.registerBeanDefinition("hello",HelloBeanDefinition);
        beanFactory.setInstantiationStrategy(new CglibSubclassingInstantiationStrategy());
        HelloService hello = (HelloService) beanFactory.getBean("hello");
        hello.sayHello();
    }
}
