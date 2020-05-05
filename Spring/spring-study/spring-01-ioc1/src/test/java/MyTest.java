import com.kuang.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    public static void main(String[] args) {
        //获取AppliContext:
        ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
        UserServiceImpl userService= (UserServiceImpl) context.getBean("userServiceImpl");
        userService.getUser();
    }

}
