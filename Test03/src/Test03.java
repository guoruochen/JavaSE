/**
 * @author 郭若辰
 * @create 2017-04-10 16:40
 */
public class Test03 {
    private int i1;//实例变量声明，可以不初始化,但是系统会给变量赋默认值0
    private static int i2;//静态变量声明，可以不初始化,但是系统会给变量赋默认值0
    private static final int COUNT = 3;//常量声明与初始化 （final变量必须初始化）

    public static void main(String[] args) {
        Test03 t = new Test03();
        t.test();
        System.out.println("方法调用结束后，i1的值为" + t.i1 + ",证明方法调用结束后，局部变量被销毁了");//不管是不是在本类中，要在静态方法里面调用实例变量，必须使用引用.变量的格式
        System.out.println("i2 = " + i2);//在本类中，静态变量的可以直接在静态和非静态方法调用
        System.out.println("COUNT = " + Test03.COUNT);//在不同类中，使用类名.变量的格式调用静态变量
    }

    public void test() {
        int i1 = 1;//局部变量必须初始化
        System.out.println("在方法中局部变量i1的值为" + i1 + "，很明显，局部变量覆盖了成员变量");
        {
            //!int i1 = 2;不能在嵌套代码块定义重复变量
        }
    }
}
