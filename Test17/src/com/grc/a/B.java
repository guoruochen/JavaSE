package com.grc.a;

/**
 * @author 郭若辰
 * @create 2017-04-20 14:44
 */
public class B {
    private AA aa;//包访问权限的类只能在同包访问

    public static void main(String[] args) {
        A a = new A();//public类可以在任何地方访问
        //!System.out.println(a.i1); private变量只能在本类访问
        System.out.println(a.i2);//包访问权限变量只能在同包访问
        System.out.println(A.i3);//protected变量可以在同包访问
        System.out.println(a.i4);//public变量可以在任何地方访问
        //!a.a(); private方法只能在本类访问
        a.b();//包访问权限方法只能在同包访问
        A.c();//protected方法可以在同包访问
        a.d();//public方法可以在任何地方访问
    }
}
