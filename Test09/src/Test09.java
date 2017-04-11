/**
 * @author 郭若辰
 * @create 2017-04-11 15:21
 */
public class Test09 {
    public static void main(String[] args) {
        int a = 6;
        int b = 3;
        int c = 8;
        int d = -8;
        System.out.println("按位与 " + (a & b));//2
        System.out.println("按位或 " + (a | b));//7
        System.out.println("按位非 " + (~a));//-7
        System.out.println("按位异或 " + (a ^ b));//5
        System.out.println("一个数异或同一个数两次 " + (a ^ b ^ b));//还是初始值6
        System.out.println("将8左移1位 " + (c << 1));//16
        System.out.println("将8右移1位 " + (c >> 1));//4
        System.out.println("将8无符号右移1位 " + (c >>> 1));//4
        System.out.println("将-8右移1位 " + (d >> 1));//-4
        System.out.println("将-8无符号右移1位 " + (d >>> 1));//2147483644

        //面试题：如何在不使用第三方变量的前提下交换两个数的值
        method_1();
        method_2();
        method_temp();
    }

    //这种方式不建议使用，如果两个数过大，和会超出int范围，底层会自动进行强制转换，有数据溢出的可能性
    private static void method_1() {
        int m = 3;
        int n = 5;
        System.out.println("交换之前m=" + m + ",n=" + n);
        m = m + n;
        n = m - n;
        m = m - n;
        System.out.println("交换之后m=" + m + ",n=" + n);
    }

    //利用“个数异或同一个数两次还是这个数”的原理
    private static void method_2() {
        int x = 3;
        int y = 5;
        System.out.println("交换之前x=" + x + ",y=" + y);
        x = x ^ y;
        y = x ^ y;//这时y就相当于x^y^y =x
        x = x ^ y;//这时x就相当于x^y^x=y
        System.out.println("交换之后x=" + x + ",y=" + y);
    }

    //实际开发中最好使用第三方变量，这样提高代码可读性
    private static void method_temp() {
        int a = 3;
        int b = 5;
        System.out.println("交换之前a=" + a + ",b=" + b);
        int temp;
        temp = b;
        b = a;
        a = temp;
        System.out.println("交换之后a=" + a + ",b=" + b);
    }
}
