package com.kuang.pojo;

public class Hello {
    private String str;
    public String getStr(){
        return this.str;
    }
    public void setStr(String str){
        this.str=str;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "str='" + str + '\'' +
                '}';
    }
}
