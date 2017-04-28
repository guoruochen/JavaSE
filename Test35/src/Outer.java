import com.sun.webkit.ContextMenu;

/**
 * @author 郭若辰
 * @create 2017-04-27 11:31
 */
public class Outer {

    private int a = 1;

    public void show() {
        //在外部类的非静态方法中创建内部类对象的格式：内部类 引用=new 内部类();
        Inner_1 inner_1 = new Inner_1();
        inner_1.print();
        //注意在外部类中也可以访问内部类的private内容
        System.out.println("内部类的private变量b = " + inner_1.b);
    }

    //成员内部类,成员内部类可以是private、包访问权限和protected的，还可以是static的
    class Inner_1 {//字节码文件名Outer$Inner_1.class
        private int b = 1;

        public void print() {
            //内部类可以直接访问外部类的内容，包括private内容
            System.out.println("外部类的private变量a = " + a);
            //原因：内部类持有了外部类.this，编译器自动帮着添加了外部类.this
            System.out.println("外部类的private变量a = " + Outer.this.a);
        }
    }

    //成员内部类也可以是private的，如果要在别的类使用内部类对象，就要设置一个getter（protected差不多，就是权限扩大了点）
    private class Inner_2 implements A {
    }

    //要在别的类使用private内部类，必须有getter
    public Inner_2 getInner_2(){
        return new Inner_2();
    }

    //静态内部类,如果内部类中定义了静态内容，该内部类必须是静态内部类
    static class Inner_3{
        private static int i;
        private int x;
    }

    //定义局部内部类的方法
    public void method(final int z){
        int x=10;
        final int y=10;

        //局部内部类
        class Inner_4{//字节码文件名Outer$1Inner_4.class
            private void go(){
                System.out.println("外部类中的a="+Outer.this.a);//局部内部类也可以访问外部类成员
                System.out.println(x);  //JDK1.7时，局部内部类只能访问方法的final局部变量，JDK1.8取消了这个限制
                System.out.println(y);
                System.out.println(z);
            }
        }
        Inner_4 inner_4=new Inner_4();
        inner_4.go();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.show();
        //在外部类的静态方法中必须借助外部类对象来创建内部类对象，格式：外部类.内部类 引用=外部类引用.new 内部类()
        Outer.Inner_1 inner_1 = outer.new Inner_1();
        inner_1.print();
        //private内部类对象在本类中随意获取
        Outer.Inner_2 inner_2 = outer.new Inner_2();
        //在外部类的静态方法中创建静态内部类对象不需要借助外部类
        Inner_3 inner_3 = new Inner_3();
        outer.method(1);
    }
}

interface A {
}

class OuterTest{
    public static void main(String[] args) {
        Outer outer = new Outer();
        //在别的类必须借助外部类对象来创建内部类对象，格式：外部类.内部类 引用=外部类引用.new 内部类()
        Outer.Inner_1 inner_1 = outer.new Inner_1();
        inner_1.print();
        //!System.out.println("内部类中的b="+inner_1.b);//注意：在别的类不能访问内部类的private成员
        //获取private内部类的对象
        A a = outer.getInner_2();
        //在别的类创建静态内部类对象
        Outer.Inner_3 inner_3 = new Outer.Inner_3();
    }
}