package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {
//    @Test
//    public void test() {
//        //第一步：获得sqlSession
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
//        List<User> userList=mapper.getUserList();
//        for(User u:userList){
//            System.out.println(u);
//            System.out.println("==================");
//        }
//        sqlSession.close();
//    }
//    @Test
//    public void getId(){
//        SqlSession sqlSession=MybatisUtils.getSqlSession();
//        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
//        User user=mapper.getUserById(1);
//        System.out.println(user);
//        sqlSession.close();
//    }
//    @Test
//    public void delete(){
//        SqlSession sqlSession=MybatisUtils.getSqlSession();
//        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
//        boolean b=mapper.deleteUser(1);
//        System.out.println(b);
//        sqlSession.commit();
//        sqlSession.close();
//    }
//    @Test
//    public void add(){
//        SqlSession sqlSession=MybatisUtils.getSqlSession();
//        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
//        int i=mapper.addUser(new User(6,"zxs","666"));
//        System.out.println(i);
//        //提交事务
//        sqlSession.commit();
//        sqlSession.close();
//    }
//    @Test
//    public void update(){
//        SqlSession sqlSession=MybatisUtils.getSqlSession();
//        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
//        int i=mapper.updateUser(new User(1,"aa","aa"));
//        System.out.println(i);
//        sqlSession.commit();
//        sqlSession.close();
//    }

    //    @Test
//    public void addUser2(){
//        SqlSession sqlSession=MybatisUtils.getSqlSession();
//        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
//        Map<String,Object> map=new HashMap<String, Object>();
//        map.put("userID",101);
//        map.put("userName","hello");
//        map.put("userPwd","1231312");
//        mapper.addUser2(map);
//        sqlSession.commit();
//        sqlSession.close();
//
//    }
    @Test
    public void cha2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", 2);
        map.put("name", "王五");
        User user = mapper.getUserById2(map);

        //System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void like() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserLike("%王%");
        for (User u : userList) {
            System.out.println(u);
        }

    }
}
