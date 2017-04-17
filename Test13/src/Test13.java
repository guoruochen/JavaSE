import java.util.HashSet;
import java.util.Set;

/**
 * @author 郭若辰
 * @create 2017-04-17 19:52
 */
public class Test13 {
    public static void main(String[] args) {
        //累加思想：求从1到100的和
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println("1加到100的和为" + sum);

        //计算器思想：求1-100之间6的倍数出现的次数
        int count = 0;
        for (int i = 1; i < 100; i++) {
            if (i % 6 == 0) {
                System.out.println(i + "是6的倍数");
                count++;
            }
        }
        System.out.println("1-100之间6的倍数出现了" + count + "次");

        //循环嵌套：打印九九乘法表
        for (int i = 1; i < 10; i++) {//外层循环控制行数
            for (int j = 1; j <= i; j++) {//内层循环控制列数
                System.out.print(i + "*" + j + "=" + (i * j) + "\t");
            }
            System.out.println();
        }

        //foreach
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        for (Integer integer : set) {
            System.out.println(integer);
        }
    }
}
