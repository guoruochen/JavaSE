import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 郭若辰
 * @create 2017-04-11 16:17
 */
public class Test10 {
    /*
    多个if/if-else和if-else if-else if...else的使用场景：
    1.同类条件的判断可以使用多个if/if-else，也可以使用if-else if-else if...-else，不过后者更好，有一个条件成立立刻终止判断，节约性能
    2.不同类条件的判断必须使用多个if/if-else
     */
    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("请输入您的成绩：");
        try {
            int score = Integer.parseInt(in.readLine());
            if (score >= 0 && score < 60) {
                System.out.println("您的成绩为不及格");
            } else if (score >= 60 && score < 70) {
                System.out.println("您的成绩为D");
            } else if (score >= 70 && score < 80) {
                System.out.println("您的成绩为C");
            } else if (score >= 80 && score < 90) {
                System.out.println("您的成绩为B");
            } else if (score >= 90 && score <= 100) {
                System.out.println("您的成绩为A");
            } else {
                System.out.println("您的成绩不符合要求");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
