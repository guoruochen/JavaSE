/**
 * @author 郭若辰
 * @create 2017-04-25 11:49
 */
abstract class Fu{

    //抽象类中也有构造函数，是为了给父类的子对象进行初始化
    public Fu(){
        System.out.println("父类构造函数");
    }

    //abstract不能和private、static和final共存
    //!private abstract void test();
    //!static abstract void test();
    //!final abstract void test();

    //抽象类中可以定义抽象方法和具体方法，可以都是抽象方法，也可以都是具体方法
    public abstract void absA();
    public abstract void absB();
    public void aa(){
        System.out.println("父类的aa()方法");
    }
}

public class Zi extends Fu{

    //实现父类的抽象方法absA()
    public void absA() {
        System.out.println("子类实现父类的抽象方法absA");
    }

    //实现父类的抽象方法absB()
    public void absB() {
        System.out.println("子类实现父类的抽象方法absB");
    }

    //覆盖父类的方法aa()
    public void aa(){
        System.out.println("子类的aa()方法");
    }

    public static void main(String[] args){
        //如果某类继承了抽象类，并想创建子类对象，那么就必须实现抽象类中所有抽象方法
        Zi z=new Zi();//会调用抽象类构造函数
        z.aa();//子类的aa()方法
        z.absA();//子类实现父类的抽象方法absA
        z.absB();//子类实现父类的抽象方法absB
        //!Fu fu=new Fu(); 抽象类不能被实例化，因为调用抽象方法没意义
    }
}