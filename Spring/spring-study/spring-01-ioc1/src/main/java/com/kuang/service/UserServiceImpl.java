package com.kuang.service;


import com.kuang.mapper.UserDao;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void getUser(){
        userDao.getUser();
    }
    public void setUserDao(UserDao userDao){
        this.userDao=userDao;
    }
}
