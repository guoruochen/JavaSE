/**
 * @author 郭若辰
 * @create 2017-04-10 13:15
 */
public class Test01 {
    public static void main(String[] args) {
        byte b = 1;
        short s = 2;
        int i = 3;
        long l = 232323232323L;//超过了int的范围，要在整数后面加L
        float f = 0.1f;//给float变量赋值，必须要在小数后面加f，否则会被编译器当做double值
        double d = 0.2;
        char c = 'a';
        //!b = c;char类型的变量不能赋给byte类型的变量
        //!s = c;char类型的变量不能赋给short类型的变量
        i = c;//char类型的变量可以赋给int类型的变量
        l = c;//char类型的变量可以赋给long类型的变量
        f = c;//char类型的变量可以赋给float类型的变量
        d = c;//char类型的变量可以赋给double类型的变量
        int i1 = (int) 1.1;
        System.out.println("将小数1.1强制类型转换之后赋给整数类型，结果为：" + i1);
        //!byte b1 = 128;
        byte b1 = (byte) 128;
        System.out.println("使用强制类型转换给byte变量赋值128之后的结果为：" + b1 + ",这种现象叫做溢出");
        //!byte b2 = i;
        byte b2 = (byte) i;
        System.out.println("使用强制类型转换将int变量赋给byte变量的结果为：" + b2);
    }
}
