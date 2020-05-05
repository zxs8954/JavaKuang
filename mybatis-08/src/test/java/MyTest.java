import com.kuang.dao.BlogMapper;
import com.kuang.pojo.Blog;
import com.kuang.utils.IDUtils;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class MyTest {
    //    @Test
//    public void test(){
//        SqlSession sqlSession= MybatisUtils.getSqlSession();
//        BlogMapper mapper=sqlSession.getMapper(BlogMapper.class);
//        mapper.addBlog(new Blog("1","Mybatis如此简单","狂神说",new Date(),999));
//        mapper.addBlog(new Blog(IDUtils.getId(),"Java","张雪松",new Date(),1000));
//    }
//    @Test
//    public void test() {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
//        Map map=new HashMap();
//       map.put("title","addddd");
//       List<Blog> blogList=mapper.queryBlogChoose(map);
//       for(Blog b:blogList){
//           System.out.println(b);
//       }
//        sqlSession.close();
//    }
    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map map=new HashMap();
        ArrayList<String> ids=new ArrayList<String>();
//        ids.add("1");
//        ids.add("3");
        map.put("ids",ids);
        List<Blog> blogList=mapper.queryBlogForeach(map);
        for(Blog b:blogList){
            System.out.println(b);
        }
        sqlSession.close();
    }
}
