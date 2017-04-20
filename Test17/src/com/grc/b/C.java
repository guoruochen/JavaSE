package com.grc.b;

//import的作用：简化类名书写
//注意：import导入的是类，不是包  如果想用别的工程的API，必须加依赖，import只是简化书写而已！！！
import com.grc.a.A;

/**
 * @author 郭若辰
 * @create 2017-04-20 14:57
 */
public class C extends A{
    //! private AA aa; 包访问权限的类无法在不同包访问

    public static void main(String[] args) {
        A a = new A();
        //!System.out.println(a.i1); private变量只能在本类访问
        //!System.out.println(a.i2);//包访问权限变量只能在同包访问
        System.out.println(i3);//protected变量可以在不同包的子类访问
        System.out.println(a.i4);//public变量可以在任何地方访问
        //!a.a(); private方法只能在本类访问
        //!a.b();//包访问权限方法只能在同包访问
        c();//protected方法可以在不同包的子类访问
        a.d();//public方法可以在任何地方访问
    }
}
