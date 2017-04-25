/**
 * @author 郭若辰
 * @create 2017-04-25 10:12
 */
public class Fu {
    //父类的实例变量
    private String s = "fulei";//private变量虽然可以继承，但只能被父类对象直接访问
    int a;
    protected int b;
    public int c;


    //静态代码块，类加载时执行
    static {
        System.out.println("父类加载");
    }

    //父类的构造函数（为了试验，只写一个有参的），子类并不能继承父类的构造函数
    public Fu(int x) {
        this.aa();//这里是由子类对象的引用来调用父类的构造函数，this指向的是子类对象，所以调用的是子类中覆盖方法
        System.out.println("父类的有参构造函数");
    }

    public void aa() {
        System.out.println("父类的aa()方法");
    }

    void bb() {
        System.out.println("父类的bb()方法");
    }

    private void siyouff() {
        System.out.println("这是父类的私有方法");
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
}

class Zi extends Fu {
    //子类实例变量
    private String s = "zilei";
    private int a = 1;
    private int b = 1;
    private int c = 1;
    private int num = 1;

    //静态代码块，类加载时执行
    static {
        System.out.println("子类加载");
    }

    //构造代码块
    {
        System.out.println("使用构造代码块进行初始化时，num=" + num);//此时指定初始化已经完成了 num = 1
        num = 10;//构造代码块初始化
    }

    public Zi() {
        super(10);//父类没有无参构造函数时，必须在子类构造函数的第一行显式地添加super(参数)来调用父类的有参构造函数
        //初始化父类子对象时，子类实例变量并未指定初始化。等父类初始化完毕后，才执行子类的指定初始化
        //指定初始化之后，进行构造代码块初始化
        System.out.println("使用子类构造函数进行初始化时，num=" + num);//此时num已经完成了构造代码块初始化，值为10
    }

    //!public Fu(int x){} 子类不能继承父类构造函数
    public Zi(int x) {
        super(x);
        System.out.println("子类有参构造函数，参数为" + x);
    }

    public static void main(String[] args) {
        System.out.println("main()方法");
        Zi zilei = new Zi();
        zilei.aa();//子类的aa()方法1     同名同参数列表的方法会被覆盖
        System.out.println(zilei.s);//zilei   子类对象会默认访问同名的子类变量
        System.out.println(zilei.getS());//fulei  父类的private变量会被继承，且没有被覆盖
        System.out.println(zilei.b);//1   子类对象会默认访问同名的子类变量
        System.out.println(zilei.a);//1   子类对象会默认访问同名的子类变量
        System.out.println(zilei.c);//1   子类对象会默认访问同名的子类变量
        zilei.bb();//父类中的b为0        同名变量不会被覆盖，并且使用super.变量可以访问父类的同名变量
        //!super.aa();  super关键字不能在静态方法里使用

        Zi zi = new Zi(99);
        System.out.println(zi);//所有类都继承了Object类，所以可以使用Object类的toString()等方法
    }

    //本方法第一次调用时，是在父类构造函数中，此时num只被默认初始化为0，还没有进行指定初始化，必须等待父类子对象初始化完成
    //本方法第二次调用时，父类初始化已经完成，num被构造代码块初始化为1
    public void aa() {
        super.aa();//使用super.方法可以调用父类的同名方法
        System.out.println("子类的aa()方法，此时num=" + num);
    }

    //扩大存取权限
    public void bb() {
        System.out.println("父类中的b为" + super.b);
    }

    //改变返回值类型为原返回值类型的子类
    public Zi cc() {
        return new Zi();
    }

    //子类方法无法覆盖父类的private方法，如果子类中定义一个与它同名同参数列表的方法，就相当于子类定义了一个新方法
    private void siyouff() {
        System.out.println("这是子类的私有方法");
    }

}
