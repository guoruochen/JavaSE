/**
 * @author 郭若辰
 * @create 2017-04-24 13:47
 */
public class Test23 {
    private static int a = 1;//静态变量a存储在方法区，字面量1存储在运行时常量池
    private final int b = 2;//字面量2存储在运行时常量池
    private int c = 3;//字面量3存储在运行时常量池
    private String str_1 = "abc";//字面量"abc"存储在运行时常量池
    private String str_2 = new String("abc");//字符串没有被创建

    public static void main(String[] args) {
        A obj = new A(25, "k");
        obj.toMyPrint(1);
        System.out.println(a);//静态变量可以直接在静态方法中调用
        //!System.out.println(b); 非静态变量不可以直接在静态方法中调用
        //!System.out.println(c); 非静态变量不可以直接在静态方法中调用
        //!System.out.println(str_1); 非静态变量不可以直接在静态方法中调用
        //!System.out.println(str_2); 非静态变量不可以直接在静态方法中调用
        aa(); //静态方法可以直接在静态方法中调用
        //!bb(); 非静态方法不可以直接在静态方法中调用
    }

    public static int getA() {
        return a;
    }

    public static void setA(int a) {
        Test23.a = a;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public String getStr_1() {
        return str_1;
    }

    public void setStr_1(String str_1) {
        this.str_1 = str_1;
    }

    public String getStr_2() {
        return str_2;
    }

    public void setStr_2(String str_2) {
        this.str_2 = str_2;
    }

    public int getB() {
        return b;
    }

    public static void aa() {
    }//静态方法aa()的字节码被存储在方法区，可以使用类.方法调用

    public void bb() {
    }//方法bb()的字节码被存储在方法区，由于没有创建Test22对象所以无法调用该方法
}
