/**
 * @author 郭若辰
 * @create 2017-04-24 15:15
 */
public class Test25 {
    private int a;//默认初始化
    private static int count;//默认初始化
    private static int num = 1;//指定初始化
    private static String name;//默认初始化

    //静态代码块，用于初始化类（只能初始化类的静态变量，不过使用静态代码块的类一般全都是静态变量），只在类加载的时候执行一次
    //因为有些类不需要创建对象，不能通过构造函数初始化，所以只能通过静态代码块初始化类（比如JDBC类）
    static {
        //!a=1; 静态代码块的规则与静态方法相同
        System.out.println("count的默认初始化" + count);
    }
}