/**
 * @author 郭若辰
 * @create 2017-04-10 16:40
 */
public class Test03 {
    private int i1;//实例变量声明，可以不初始化,但是JVM会给变量默认初始化为0
    private static int i2;//静态变量声明，可以不初始化,但是JVM会给变量默认初始化为0

    public static void main(String[] args) {
        Test03 t = new Test03();
        t.test();
        System.out.println("方法调用结束后，i1的值为" + t.i1 + ",证明方法调用结束后，局部变量被销毁了");//不管是不是在本类中，要在静态方法里面调用实例变量，必须使用引用.变量的格式
        System.out.println("i2 = " + i2);//在本类中，静态变量的可以直接在静态和非静态方法调用，之所以能直接调用静态变量，是编译器自动在i2前加了类名Test03.
        System.out.println("Test类的final静态变量COUNT = " + Test.COUNT);//在不同类中，要使用类名.变量的格式调用静态变量
    }

    public void test() {
        System.out.println("在非静态方法中，i1的值为" + i1);//在本类中，非静态变量的可以直接在非静态方法调用，之所以能直接调用实例变量，是编译器自动在i1前加了this.
        int i1 = 1;//局部变量必须初始化
        System.out.println("定义局部变量i1后，i1的值为" + i1 + "，很明显，局部变量覆盖了成员变量");
        {
            //!int i1 = 2;不能在局部代码块中重复定义同名局部变量
        }
    }
}

class Test{
    static final int COUNT = 3;//final静态变量（也可以视作常量）的声明与指定初始化 （final变量必须初始化）
}
