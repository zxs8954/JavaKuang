import com.kuang.pojo.Student;
import com.kuang.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {
//    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Student student = (Student) context.getBean("student");
//        System.out.println(student.toString());
//    }

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("UserBeans.xml");
        User user = context.getBean("user221", User.class);
        User user1=context.getBean("user221",User.class);
        System.out.println(user==user1);
        System.out.println(user);
    }
}
