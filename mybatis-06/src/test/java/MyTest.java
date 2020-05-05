import com.kuang.dao.StudentMapper;
import com.kuang.dao.TeacherMapper;
import com.kuang.pojo.Student;
import com.kuang.pojo.Teacher;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {

    //    @Test
//    public void test(){
//        SqlSession sqlSession= MybatisUtils.getSqlSession();
//        TeacherMapper mapper=sqlSession.getMapper(TeacherMapper.class);
//        Teacher teacher=mapper.getTeacher(1);
//        System.out.println(teacher);
//        sqlSession.close();
//    }
//    @Test
//    public void test() {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//        List<Student> studentList=mapper.getStudent();
//       for(Student s:studentList){
//           System.out.println(s);
//       }
//        sqlSession.close();
//    }
    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = mapper.getStudent2();
        for (Student s : studentList) {
            System.out.println(s);
        }
        sqlSession.close();
    }
}
