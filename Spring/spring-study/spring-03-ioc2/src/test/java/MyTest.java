import com.kuang.pojo.User;
import com.kuang.pojo.UserT;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        //Spring就类似于婚介网站！  找对象
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserT userT = (UserT) context.getBean("u2");
//        User user2= (User) context.getBean("user");
        //System.out.println(user==user2);
        userT.show();
    }
}
