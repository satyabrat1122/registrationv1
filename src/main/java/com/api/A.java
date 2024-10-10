package com.api;

public class A {
    public static void main(String[] args) {
    A a1=new A();
    int val=a1.test();
        System.out.println(val);
    C c1=new C();
    c1.test2();
    }
    public int test(){
        B b1=new B();
        return b1.test1();
    }
}