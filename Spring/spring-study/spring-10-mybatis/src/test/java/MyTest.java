
import com.kuang.mapper.UserMapper;
import com.kuang.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MyTest {
    @Test
    public void test(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper mapper=context.getBean("userMapper2", UserMapper.class);
        for(User user:mapper.selectUser()){
            System.out.println(user);
        }
    }
}
