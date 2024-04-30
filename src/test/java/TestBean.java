import beans.factory.BeanFactory;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class TestBean {
    @Test
    public void testBean() throws Exception {

        HelloService helloservice = new HelloService();
        BeanFactory bf =new BeanFactory();
        bf.registerBean("beanhello",new HelloService());
        HelloService helloservice1 = (HelloService) bf.getBean("beanhello");
        assertThat(helloservice1).isNotNull();
        assertThat(helloservice1.sayHello()).isEqualTo("hello");


    }

    class HelloService {
        public String sayHello() {
            System.out.println("hello");
            return "hello";
        }
    }

}


