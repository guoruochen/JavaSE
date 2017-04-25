/**
 * @author 郭若辰
 * @create 2017-04-25 13:07
 */
interface JieKou1 {
    String STR = "abc";//接口中的变量默认是public、static和final的

    void aa();//接口中的方法默认是public和abstract的
}

interface JieKou2 {
    void bb();
}

//接口与接口之间是继承关系，而且可以多继承
interface JieKou3 extends JieKou1, JieKou2 {
}

abstract class Fu {
    public abstract void cc();
}

public class Zi extends Fu implements JieKou1, JieKou2 {

    @Override
    public void aa() {
        System.out.println("实现了接口1的方法,STR = " + STR);
    }

    @Override
    public void bb() {
        System.out.println("实现第二个接口的bb()方法");
    }

    @Override
    public void cc() {
        System.out.println("覆盖父类的cc()方法");
    }

    public static void main(String[] args) {
        Zi z = new Zi();
        z.aa();
        z.bb();
        z.cc();
    }
}