import com.kuang.dao.UserMapper;
import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {
    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SqlSession sqlSession1 = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(2);
        System.out.println(user);
        sqlSession.close();

        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
        User user1 = mapper1.queryUserById(2);
        System.out.println(user1);
        sqlSession1.close();
        System.out.println(user==user1);
    }
}
