/**
 * @author 郭若辰
 * @create 2017-04-17 19:39
 */
public class Test12 {
    public static void main(String[] args) {
        //while和do-while唯一的区别:do-while至少会执行一次
        int x = 1;
        while (x < 1) {
            System.out.println("这句不会被执行！");
        }
        do {
            System.out.println("至少会执行一次，x=" + x);
            x++;
        } while (x < 1);

        //累加思想：求从1到100的和
        int i = 1;
        int sum = 0;
        while (i <= 100) {
            sum += i;
            i++;
        }
        System.out.println("1加到100的和为" + sum);

        //计算器思想：求1-100之间6的倍数出现的次数
        int m = 1;
        int count = 0;
        while (m < 100) {
            if (m % 6 == 0) {
                count++;
                System.out.println(m + "是6的倍数！");
            }
            m++;
        }
        System.out.println("1-100之间6的倍数出现了" + count + "次");
    }
}
