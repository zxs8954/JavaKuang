package com.kuang.demo01;

public class Client {
    public static void main(String[] args) {
        //代理    帮房东出租房子，有一些附属操作
        Proxy proxy=new Proxy(new Host());
        //不用面对房东
        proxy.rent();
    }
}
