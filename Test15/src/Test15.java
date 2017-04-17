import java.util.Scanner;

/**
 * @author 郭若辰
 * @create 2017-04-17 20:16
 */
public class Test15 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("请输入整数x：");
        int x = s.nextInt();
        System.out.print("请输入整数y：");
        int y = s.nextInt();
        System.out.print("请输入考试分数：");
        int score = s.nextInt();
        s.close();
        Test15 t = new Test15();
        System.out.println("x+y=" + t.add(x, y));
        System.out.println("x-y=" + t.minus(x, y));
        System.out.println("x*y=" + t.multiplyBy(x, y));
        System.out.println("x/y=" + t.divideBy(x, y));
        System.out.println(t.getLevel(score));
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int minus(int a, int b) {
        return a - b;
    }

    public int multiplyBy(int a, int b) {
        return a * b;
    }

    public double divideBy(int a, int b) {
        if (b != 0) {
            return (double) (a / b);
        } else {
            return 0;
        }
    }

    //如果返回值类型不是void，必须确定每一条代码路径都将返回该类型所对应的值
    public String getLevel(int score) {
        if (score >= 0 && score < 60) {
            return "您的成绩为不及格";
        } else if (score >= 60 && score < 70) {
            return "您的成绩为D";
        } else if (score >= 70 && score < 80) {
            return "您的成绩为C";
        } else if (score >= 80 && score < 90) {
            return "您的成绩为B";
        } else if (score >= 90 && score <= 100) {
            return "您的成绩为A";
        } else {
            return "您的成绩为不及格";
        }
    }
}