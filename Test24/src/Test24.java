import java.util.Date;

/**
 * @author 郭若辰
 * @create 2017-04-24 14:39
 */
public class Test24 {
    private String name;
    private Date date;

    public String getName() {
        return name;
    }

    public Test24 setName(String name) {
        this.name = name;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Test24 setDate(Date date) {
        this.date = date;
        return this;
    }

    //重载构造函数
    public Test24() {
        System.out.println("无参构造函数！");
    }

    public Test24(String name) {
        this();//this()只能在构造函数的第一行调用且只能调用一次
        //!super(); this()和super()不能同时调用
        this.name = name;//在构造函数中的第一种使用场景：在形参名和实例变量名相同时，标明实例变量
        System.out.println("参数为String的构造函数，参数为" + this.name);
    }

    public Test24(Date date) {
        this("k");
        this.date = date;
        System.out.println("参数为Date的构造函数，参数为" + date);
    }

    public void aa() {
        System.out.println("aa()方法");
    }

    public void bb() {
        System.out.println("name=" + name);//实际上编译器自动添加this关键字，this.name
        System.out.println("date=" + date);//实际上编译器自动添加this关键字，this.date
        aa();//实际上编译器自动添加this关键字，this.aa()
    }

    public static void main(String[] args) {
        //!System.out.println(this); 静态方法不能使用this
        //!System.out.println(name); 静态方法中不能直接调用非静态变量
        //!System.out.println(date); 静态方法中不能直接调用非静态变量
        //!bb(); 静态方法中不能直接调用非静态方法
        Test24 t = new Test24(new Date());
        System.out.println(t.name);
        System.out.println(t.date);
        t.bb();
    }
}
