package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MapperTest {
    public static Logger logger=Logger.getLogger(Mapper.class);
//    @Test
//    public void test() {
//        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        Mapper mapper = sqlSession.getMapper(Mapper.class);
//        User userList = mapper.getUserById(2);
//        System.out.println(userList);
//        logger.info("1");
//        logger.debug(2);
//        sqlSession.close();
//    }
    @Test
    public void getByLimit(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        Mapper mapper=sqlSession.getMapper(Mapper.class);
        Map map=new HashMap();
        map.put("startIndex",1);
        map.put("pageSize",5);
        List<User> userList=mapper.getUserByLimit(map);
        for(User u:userList){
            System.out.println(u);
        }

    }
}
