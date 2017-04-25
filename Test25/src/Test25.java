import java.util.Arrays;

/**
 * @author 郭若辰
 * @create 2017-04-24 15:15
 */
public class Test25 {
    private int a;//默认初始化
    private static int count;//默认初始化
    private static int num = 1;//指定初始化
    private static String name;//默认初始化

    //静态代码块，用于初始化类（只能初始化类的静态变量，不过使用静态代码块的类一般全都是静态变量），只在类首次加载的时候执行一次
    //因为有些类不需要创建对象，不能通过构造函数初始化，所以只能通过静态代码块初始化类（比如JDBC类）
    static {
        System.out.println("*************************静态代码块***********************");
        //!a=1; 静态代码块的规则与静态方法相同
        System.out.println("count的默认初始化,count = " + count);
        System.out.println("num的指定初始化，num = " + num);
        System.out.println("name的默认初始化，name = " + name);
        name = "haha";//静态代码块初始化
        num = num + 1;//静态代码块初始化
        System.out.println("name的静态代码块初始化，name = " + name);
        System.out.println("num的静态代码块初始化，num = " + num);
    }

    //构造代码块，在调用构造函数之前执行，创建几个对象就调用几次，这是用来给所有对象来一次初始化
    {
        System.out.println("*************************构造代码块***********************");
        System.out.println("a的默认初始化,a = " + a);
        a = 1;
        System.out.println("a的构造代码块初始化,a = " + a);
        name = "hehe";
        num = num + 1;
        System.out.println("name的构造代码块初始化，name = " + name);
        System.out.println("num的构造代码块初始化，num = " + num);
    }

    public Test25() {
        count++;
        System.out.println("**************************第" + count + "次创建对象***************************");
        name = "heihei";//构造函数初始化
        num = num + 1;//构造函数初始化
        System.out.println("构造函数初始化的name：" + name);
        System.out.println("构造函数初始化的num：" + num);
    }

    public static void main(String[] args) {//编译器自动传入了一个new String[0]
        //System.out.println(args);[Ljava.lang.String;@4554617c
        //System.out.println(Arrays.toString(args)); []
        //System.out.println(args.length); 0
        for (int i = 0; i < 3; i++) {
            new Test25();
        }
        System.out.println("一共创建了" + count + "个对象");//与this同理，编译器帮着自动添加了类名，Test27.count
        print();//与this同理，编译器帮着自动添加了类名，Test27.print();
    }

    public static void print() {
        //!static int i; 局部变量不能被static关键字修饰
        //!System.out.println(a); 静态方法不能直接调用非静态成员
        //!System.out.println(this); 静态方法不能使用this
        //!System.out.println(super.toString()); 静态方法不能使用super

        //局部代码块：用来控制某些变量的生命周期
        {
            num = 100;//这里局部变量num会暂时覆盖实例变量num，但是局部代码块执行完毕后，局部变量num被销毁
            System.out.println("局部变量num = " + num);
        }
    }

    public int getA() {
        return a;
    }

    public Test25 setA(int a) {
        this.a = a;
        return this;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Test25.count = count;
    }

    public static int getNum() {
        return num;
    }

    public static void setNum(int num) {
        Test25.num = num;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Test25.name = name;
    }
}