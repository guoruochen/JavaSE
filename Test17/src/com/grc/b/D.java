package com.grc.b;

import com.grc.a.A;

/**
 * @author 郭若辰
 * @create 2017-04-20 15:09
 */
public class D {
    //!private AA aa; 包访问权限的类无法在不同包访问

    public static void main(String[] args) {
        A a=new A();
        //!System.out.println(a.i1); private变量只能在本类访问
        //!System.out.println(a.i2); 包访问权限变量只能在同包访问
        //!System.out.println(A.i3); protected变量无法在不同包的非子类访问
        System.out.println(a.i4);//public变量可以在任何地方访问
        //!a.a(); private方法只能在本类访问
        //!a.b(); 包访问权限方法只能在同包访问
        //!A.c(); protected方法无法在不同包的非子类访问
        a.d();//public方法可以在任何地方访问
    }
}
