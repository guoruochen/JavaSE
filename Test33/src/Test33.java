/**
 * @author 郭若辰
 * @create 2017-04-27 10:12
 */
public class Test33 {
    private static final String A;
    private static final String B;

    //为了保证final变量已经被初始化，必须进行指定初始化或者静态代码块初始化
    static {
        A = "aaa";
        B = "bbb";
    }

    public static void main(String[] args) {
        /*
        用"+"连接符拼接字符串，且常量池中存在有拼接后的字符串
        那么只有当被连接的两个字符串都是字面量时，才会引用常量池中的字符串
        否则就会在常量池产生新的字符串对象
         */
        String str_1 = "aaa";
        String str_2 = "bbb";
        String str_3 = "aaabbb";
        String str_4 = "aaa" + "bbb";//两个字面量直接相加在编译时就确定为aaabbb,不会产生新的字符串对象
        System.out.println(str_3 == str_4);
        String str_5 = str_1 + "bbb";//两个字面量直接相加在编译时就确定为aaabbb,不会产生新的字符串对象
        System.out.println(str_3 == str_5);
        String str_6 = str_1 + str_2;//两个字面量直接相加在编译时就确定为aaabbb,不会产生新的字符串对象
        System.out.println(str_3 == str_6);


        /*
        * 若在定义字符串变量时加final关键字修饰并且在声明时就赋予初始值
          * 因为s1与s2都定义成了常量，在编译时就能确定，编译时就会将常量替换，等同于
          * s4 = "aaa"+"bbb"，因此不产生新对象
         */
        final String s1 = "aaa";
        final String s2 = "bbb";
        String s3 = "aaabbb";
        String s4 = s1 + s2;
        System.out.println(s3 == s4);

        /*
        若被拼接的两个字符串都是final实例变量，且没有进行指定初始化而是进行了静态代码块初始化
        此时ss1与ss2相当于变量，因为静态代码块是在运行时才能确定，在编译时不能确定
         */
        String ss3 = "aaabbb";
        String ss4 = A + B;
        System.out.println(ss3 == ss4);


    }
}
