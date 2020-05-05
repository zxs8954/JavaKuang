import com.kuang.dao.Mapper;
import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.util.List;

public class MapperTest {
    //    @Test
//    public void test(){
//        SqlSession sqlSession= MybatisUtils.getSqlSession();
//        Mapper mappers=sqlSession.getMapper(Mapper.class);
//        List<User> userList=mappers.getUser();
//        for(User user:userList){
//            System.out.println(user);
//        }
//
//
//        sqlSession.close();
////    }
//    @Test
//    public void test() {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        Mapper mappers = sqlSession.getMapper(Mapper.class);
//        User user = mappers.getUserById(2);
//        System.out.println(user);
//        sqlSession.close();
//    }

    //    @Test
//    public void test() {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        Mapper mappers = sqlSession.getMapper(Mapper.class);
//        int o = 1000;
//        int i = mappers.addUser(new User(o, "徐良", "888"));
//        o++;
//        System.out.println(i);
//    }
//    @Test
//    public void test() {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        Mapper mappers = sqlSession.getMapper(Mapper.class);
//        mappers.updateUser(new User(5, "主线程", "888"));
//    }

//    @Test
//    public void test() {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        Mapper mappers = sqlSession.getMapper(Mapper.class);
//        mappers.deleteUser(5);
//    }
    @Test
    public void test(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        Mapper mapper=sqlSession.getMapper(Mapper.class);
        for(User user:mapper.all()){
            System.out.println(user);
        }
    }
}
