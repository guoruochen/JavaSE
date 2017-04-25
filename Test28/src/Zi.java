import java.util.Random;

/**
 * @author 郭若辰
 * @create 2017-04-25 11:24
 */
public class Zi extends Fu {
    private static Random rand = new Random();
    private final int num = 1;//final变量必须在定义时进行指定初始化赋值，且不能被改变
    private final Fu fu = new Fu();//final引用也必须在定义的时候进行指定初始化赋值，且只能指向当前对象，不能指向别的对象
    private final int A = rand.nextInt(10);//每次创建对象时都会被重新从初始化
    private static final int B = rand.nextInt(10);//在方法区中占据一块恒定不变的存储空间，只在类第一次加载时初始化

    public static void main(String[] args) {
        Zi z = new Zi();
        //! z.num = 1; final变量不能被改变
        //!z.fu = new Fu(); final引用不能指向别的对象
        Zi z1 = new Zi();
        System.out.println("第一次创建对象时，a=" + z.A);
        System.out.println("第一次创建对象时，B=" + B);
        System.out.println("第一次创建对象时，a=" + z1.A);
        System.out.println("第一次创建对象时，B=" + B);
    }

    //子类方法无法覆盖父类的private方法，这里相当于定义了一个新方法
    public void aa(){}

    //!public void bb(){} 子类无法覆盖父类的final方法

    public void cc(final Fu fu){
        //!fu=new Fu(); final引用不能指向别的对象
    }
}

//final类无法被继承，且类中所有方法都被隐式地指定为final方法
final class CannotBeOverride {
}

class Fu {
    //类中所有的private方法都隐式地指定为final的
    private void aa() {
    }

    ////final方法无法被覆盖
    public final void bb() {
    }

}