/**
 * @author 郭若辰
 * @create 2017-04-25 9:50
 */
public class Test26 {
    public static void main(String[] args) {
        Test26 t1 = new Test26();//t1引用了别的对象，这个对象变为可回收的
        t1 = new Test26();

        Test26 t2 = new Test26();//t2被赋值为null，这个对象变为可回收的
        t2 = null;

        go();

        System.gc();//强制启动GC
    }

    public static void go() {
        Test26 t3 = new Test26();//go()方法调用结束，t3会被销毁，这个对象变为可回收的
    }

    //Object类的方法，用来回收不是通过new分配内存的对象
    protected void finalize() {
        System.out.println("调用finalize()，执行一些必要的清理工作");
    }
}
