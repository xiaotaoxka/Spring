package com.wztedu.spring.wztapplicationcontext;

public class WztApplicationContextTest {
    public static void main(String[] args) throws Exception {
        WztApplicationContext wztApplicationContext
                = new WztApplicationContext("beans.xml");

        System.out.println("ok~~");
    }
}
