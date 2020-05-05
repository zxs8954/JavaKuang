package com.kuang.demo01;

public class Proxy implements Rent {
    private Host host;

    public Proxy() {
    }

    public Proxy(Host host) {
        seeHouse();
        this.host = host;
        heTong();
        fare();
    }

    public void rent() {
        host.rent();
    }
    //看房
    public void seeHouse(){
        System.out.println("中介带你看房子");
    }
    //合同
    public void heTong(){
        System.out.println("签署租赁合同");
    }
    //收中介费
    public void fare(){
        System.out.println("中介带你看房子");
    }
}
