import java.util.Date;

/**
 * @author 郭若辰
 * @create 2017-04-20 15:21
 */
public class Test18 {
    private String name;
    private Date date;

    public Test18(String name) {
        this.name = name;
        System.out.println(this.name + " has been constructed!");
    }

    public Test18(String name, Date date) {
        this.name = name;
        this.date = date;
        System.out.println(this.name + " has been constructed in " + this.date);
    }

    public static void main(String[] args) {
        //! new Test18(); 如果自己定义了构造函数，编译器就不会自动创建无参构造函数
        new Test18("k");
        new Test18("k", new Date());
    }
}
