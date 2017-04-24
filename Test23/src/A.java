/**
 * @author 郭若辰
 * @create 2017-04-24 14:07
 */
public class A {
    private String name = "abc";//此时常量池中已经存在"abc"，不用再创建
    private int age = 20;

    //构造函数的重载版本
    public A() {
    }

    public A(String name) {
        this.name = name;
    }

    public A(int age, String name) {
        this(name);
        this.age = age;
    }

    public void toMyPrint(int x) {
        myPrint(x);
    }

    public void myPrint(int z) {
        System.out.println(z);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
