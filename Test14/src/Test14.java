/**
 * @author 郭若辰
 * @create 2017-04-17 20:06
 */
public class Test14 {
    public static void main(String[] args) {
        //break:跳出最内层循环（输出结果是三行一列的*）
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                System.out.print("*");
                break;
            }
            System.out.println();
        }

        //continue：结束本次循环，继续下一次循环（输出结果为i=1 i=3，i=2和i=4的循环被结束了）
        for (int i = 1; i < 5; i++) {
            if (i % 2 == 0) {
                continue;
            }
            System.out.println("i=" + i);
        }
    }
}
