import beans.factory.BeanFactory;
import beans.factory.config.BeanDefinition;
import beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

public class TestBeanDf {

    @Test
    public void testBeanDf() throws Exception{
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(HelloService.class);
        beanFactory.registerBeanDefinition("hello",beanDefinition);
        HelloService helloService = (HelloService) beanFactory.getBean("hello");
    }
}
