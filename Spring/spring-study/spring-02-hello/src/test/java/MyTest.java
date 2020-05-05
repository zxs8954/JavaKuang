import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        //获取Spring上下文对象
        ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
        //我们的对象都在SPring中管理，我们要使用，直接取取出来
        Object hello=context.getBean("hello");
        System.out.println(hello.toString());
    }
}
