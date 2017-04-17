import java.util.Scanner;

/**
 * @author 郭若辰
 * @create 2017-04-17 9:32
 */
public class Test11 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("请输入运算方法：");
        String str = s.nextLine();
        System.out.print("请输入整数a：");
        int a = s.nextInt();
        System.out.print("请输入整数b：");
        int b = s.nextInt();
        s.close();
        switch (str) {
            case "加法":
            case "加":
                System.out.println("a+b = " + (a + b));
                break;
            case "减法":
            case "减":
                System.out.println("a-b = " + (a - b));
                break;
            case "乘法":
            case "乘":
                System.out.println("a*b = " + (a * b));
                break;
            case "除法":
            case "除":
                System.out.println("a/b = " + (a / b));
                break;
            case "求模":
            case "取模":
                System.out.println("a%b = " + (a % b));
                break;
            default:
                System.out.println("无效的运算方法！！！");
        }
    }
}
