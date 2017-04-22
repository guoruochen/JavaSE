import java.util.Arrays;

/**
 * @author 郭若辰
 * @create 2017-04-22 16:13
 */
public class Test20 {
    public static void main(String[] args) {
        System.out.println("*******************************定义数组********************************");
        int[][] arr_1 = new int[2][3];
        System.out.println("使用for循环赋值并遍历二维数组：");
        for (int i = 0; i < arr_1.length; i++) {
            for (int j = 0; j < arr_1[i].length; j++) {
                arr_1[i][j] = 1;
                System.out.print(arr_1[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("使用foreach循环赋值并遍历二维数组；");
        for (int[] x : arr_1) {
            for (int y : x) {
                y = 2;
                System.out.print(y + " ");
            }
            System.out.println();
        }
        System.out.println("对象类型+@+对象的十六进制哈希值:" + arr_1);
        System.out.println("对象的哈希值:" + arr_1.hashCode());
        System.out.println("将对象的哈希值转换为十六进制的:" + Integer.toHexString(arr_1.hashCode()));
        System.out.println("使用Arrays工具类的deepHasCode()方法获取数组对象的哈希值:" + Arrays.deepHashCode(arr_1));
        System.out.println("使用Arrays工具类的deepToString()方法将数组转换为字符串:" + Arrays.deepToString(arr_1) + "\n");

        //第二种定义格式
        int[][] arr_2 = new int[2][];
        System.out.println(arr_2);//打印引用的值，对象类型+@+数组对象的内存地址（哈希值）
        System.out.println(arr_2[0]);//null
        System.out.println(arr_2[1]);//null
        //!arr_2[0]={1,2,3};注意这是错误的！
        arr_2[0] = new int[3];
        arr_2[1] = new int[]{4, 5, 6};
        System.out.println(Arrays.deepToString(arr_2));//打印多维数组的Arrays类的静态方法

        //第三种定义格式
        int[][] arr_3 = new int[][]{{1, 2, 3}, {4, 5, 6}};
        //int[][] arr_3={{1,2,3},{4,5,6}};也是可以的
        for (int i = 0; i < arr_3.length; i++) {
            for (int j = 0; j < arr_3[i].length; j++) {
                System.out.print(arr_3[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(arr_3);//打印引用的值，对象类型+@+数组对象的内存地址（哈希值）
        System.out.println(arr_3[0]);//打印引用的值，对象类型+@+数组对象的内存地址（哈希值）
        System.out.println(arr_3[1]);//打印引用的值，对象类型+@+数组对象的内存地址（哈希值）

        //二维数组间的比较
        System.out.println("\n*******************************二维数组间比较********************************");
        int[][] a = {{1, 2}, {3, 4}};
        int[][] b = {{1, 2}, {3, 4}};
        int[][] c = new int[][]{{1, 2, 3}, {4, 5, 6}};
        int[][] d = new int[][]{{1, 2, 3}, {4, 5, 6}};
        System.out.println("== :" + (a == b));
        System.out.println("未覆盖的equals() :" + a.equals(b));
        System.out.println("覆盖后的equals() :" + Arrays.deepEquals(a, b));
        System.out.println("== :" + (c == d));
        System.out.println("未覆盖的equals() :" + c.equals(d));
        System.out.println("覆盖后的equals() :" + Arrays.deepEquals(c, d));

        //练习：将二维数组的行与列调换位置
        System.out.println("\n*******************************练习********************************");
        int[][] arr = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("交换行与列之前的二维数组：");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("交换行与列之后的二维数组：");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[j][i] + " ");
            }
            System.out.println();
        }
    }
}
