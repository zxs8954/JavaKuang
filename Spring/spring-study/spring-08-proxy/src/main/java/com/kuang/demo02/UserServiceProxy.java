package com.kuang.demo02;

public class UserServiceProxy implements UserService {
    private UserServiceImpl userServiceImpl;

    public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    public void add() {
        log("add");
        userServiceImpl.add();
    }

    public void delete() {
        log("delete");
        userServiceImpl.add();

    }

    public void update() {
        log("update");
        userServiceImpl.add();

    }

    public void query() {
        log("query");
        userServiceImpl.add();

    }
    //日志方法
    public void log(String message){
        System.out.println("使用了"+message+"方法");
    }
}
