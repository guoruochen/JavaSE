/**
 * @author 郭若辰
 * @create 2017-04-17 20:21
 */
public class Test16 {
    //方法重载最常用于构造函数
    private String name;

    public Test16() {
    }

    public Test16(String name) {
        this.name = name;
        System.out.println(name + " has been constructed");
    }

    public String getName() {
        return name;
    }

    public Test16 setName(String name) {
        this.name = name;
        return this;
    }

    public static void main(String[] args) {
        Test16 t = new Test16("k");
        System.out.println(t.add(1, 1.1));
        System.out.println(t.add(1, 1.1, 1));
        System.out.println(t.add(1.1, 1.1));
        System.out.println(t.add(1.1, 1));
    }

    //方法重载
    private double add(int a, double b) {
        return a + b;
    }

    double add(int a, double b, int c) {//参数列表的个数不同
        return add(a, b) + c;
    }

    protected int add(double a, double b) {//参数列表的类型不同
        return (int) (a + b);
    }

    public double add(double x, int y) {//参数列表的顺序不同
        return x + y;
    }
}
