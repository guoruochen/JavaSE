import java.util.Scanner;

/**
 * @author 郭若辰
 * @create 2017-04-11 11:04
 */
public class Test04 {
    public static void main(String[] args) {
        compute();
        stringConcat();
    }

    private static void compute() {
        int i = 8;
        double d = 25.5;
        System.out.println("加：" + (i + d) + "\n减：" + (i - d) + "\n乘：" + (i * d) + "\n除：" + (i / d) + "\n取模：" + (i % d));
        Scanner s = new Scanner(System.in);
        System.out.print("请输入任意整数：");
        double b = s.nextDouble();
        System.out.println((b % 1 != 0) ? "您输入的是小数" : (b % 2 == 0) ? "您输入的是偶数" : "您输入的是奇数");
        s.close();
    }

    private static void stringConcat() {
        System.out.println("5+5 = " + 5 + 5);//结果为5+5=55，过程是先拼接出"5+5=5"，然后继续进行拼接
        System.out.println("5+5 = " + (5 + 5));//结果为5+5=10，过程是先计算出10，再进行字符串拼接
        System.out.println(5 + 5 + " = 5+5");//结果为10=5+5，这是因为+操作符的顺序是从左往右，先进行了加法运算，然后才进行字符串拼接
        System.out.println("haha" + null);//结果为hahanull，这个小知识点要注意下
    }
}
