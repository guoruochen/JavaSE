import java.util.Arrays;

/**
 * @author 郭若辰
 * @create 2017-04-22 13:48
 */
public class Test19 {
    public static void main(String[] args) {
        System.out.println("*******************************定义数组********************************");
        //第一种定义格式
        int[] arr_1 = new int[3];
        arr_1[0] = 1;
        arr_1[1] = 2;
        arr_1[2] = 3;
        System.out.println("对象类型+@+对象的十六进制哈希值:" + arr_1);
        System.out.println("对象的哈希值:" + arr_1.hashCode());
        System.out.println("将对象的哈希值转换为十六进制的:" + Integer.toHexString(arr_1.hashCode()));
        System.out.println("使用Arrays工具类的hasCode()方法获取数组对象的哈希值:" + Arrays.hashCode(arr_1));
        System.out.println("使用Arrays工具类的toString()方法将数组转换为字符串:" + Arrays.toString(arr_1) + "\n");

        //第二种定义格式
        int[] arr_2 = new int[]{4, 5, 6};
        System.out.println("对象类型+@+对象的十六进制哈希值:" + arr_2);
        System.out.println("对象的哈希值:" + arr_2.hashCode());
        System.out.println("将对象的哈希值转换为十六进制的:" + Integer.toHexString(arr_2.hashCode()));
        System.out.println("使用Arrays工具类的hasCode()方法获取数组对象的哈希值:" + Arrays.hashCode(arr_2));
        System.out.println("使用Arrays工具类的toString()方法将数组转换为字符串:" + Arrays.toString(arr_2) + "\n");

        //第三种定义格式（这种定义格式不推荐使用）
        int[] arr_3 = {7, 8, 9};
        System.out.println("对象类型+@+对象的十六进制哈希值:" + arr_3);
        System.out.println("对象的哈希值:" + arr_3.hashCode());
        System.out.println("将对象的哈希值转换为十六进制的:" + Integer.toHexString(arr_3.hashCode()));
        System.out.println("使用Arrays工具类的hasCode()方法获取数组对象的哈希值:" + Arrays.hashCode(arr_3));
        System.out.println("使用Arrays工具类的toString()方法将数组转换为字符串:" + Arrays.toString(arr_3) + "\n");

        //数组常用操作1：遍历
        System.out.println("*******************************遍历********************************");
        System.out.print("使用for循环遍历一维数组：");
        for (int i = 0; i < arr_1.length; i++) {
            System.out.print(arr_1[i] + " ");
        }
        System.out.print("\n使用foreach循环遍历一维数组：");
        for (int i : arr_1) {
            System.out.print(i + " ");
        }

        //数组常用操作2：获取最值
        System.out.println("\n\n*******************************获取最值********************************");
        int[] arr_4 = {3, 5, 1, 6, 2, 43, 35, 2, 9};
        System.out.println("方法1：从数组的第一个元素开始，逐个比较：");
        int maxElement = arr_4[0];
        for (int i = 1; i < arr_4.length; i++) {
            maxElement = (maxElement > arr_4[i]) ? maxElement : arr_4[i];
        }
        System.out.println("数组最大值为:" + maxElement);
        int minElement = arr_4[0];
        for (int i = 1; i < arr_4.length; i++) {
            minElement = (minElement < arr_4[i]) ? minElement : arr_4[i];
        }
        System.out.println("数组最小值为:" + minElement);
        System.out.println("\n方法2：通过下标比较：");
        int maxIndex = 0;
        for (int i = 1; i < arr_4.length; i++) {
            arr_4[maxIndex] = (arr_4[maxIndex] > arr_4[i]) ? arr_4[maxIndex] : arr_4[i];
        }
        System.out.println("数组最大值为:" + arr_4[maxIndex]);
        int minIndex = 0;
        for (int i = 1; i < arr_4.length; i++) {
            arr_4[minIndex] = (arr_4[minIndex] < arr_4[i]) ? arr_4[minIndex] : arr_4[i];
        }
        System.out.println("数组最小值为:" + arr_4[minIndex]);
        System.out.println("\n方法3：借助Arrays的静态方法（推荐）：");
        Arrays.sort(arr_4);
        System.out.println("数组最大值为：" + arr_4[arr_4.length - 1]);
        System.out.println("数组最小值为：" + arr_4[0]);

        //数组常用操作3：排序
        System.out.println("\n*******************************排序********************************");
        int[] arr_5 = {3, 5, 6, 4, 2, 1, 8, 9, 7};
        System.out.print("方法1：使用Arrays静态方法（推荐）：");
        Arrays.sort(arr_5);
        System.out.println(Arrays.toString(arr_5));
        System.out.print("方法2：选择排序：");
        for (int i = 0; i < arr_5.length - 1; i++) {
            for (int j = i + 1; j < arr_5.length; j++) {
                if (arr_5[i] > arr_5[j]) {
                    int temp = arr_5[i];
                    arr_5[i] = arr_5[j];
                    arr_5[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr_5));
        System.out.print("方法2：冒泡排序：");
        for (int i = 0; i < arr_5.length - 1; i++) {
            for (int j = 0; j < arr_5.length - 1 - i; j++) {
                if (arr_5[j] > arr_5[j + 1]) {
                    int temp = arr_5[j];
                    arr_5[j] = arr_5[j + 1];
                    arr_5[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr_5));

        //数组常用操作4：查找某元素的索引
        int[] arr_6 = {3, 1, 4, 65, 7, 1};
        System.out.println("\n*******************************查找某元素的索引********************************");
        System.out.println("方法1：遍历查找（这种方式要查找所有元素，效率比较低）");
        for (int i = 0; i < arr_6.length; i++) {
            if (arr_6[i] == 1) {
                System.out.println("元素1的索引为 " + i);
            }
        }
        System.out.println("\n方法2：二分法（推荐）");
        //使用Arrays类的binarySearch静态方法，本质就是二分法
        //使用此方法必须先对数组排序，如果数组未排序将产生不可预料的后果
        //如果数组中有多个该值，则无法保证找到的是哪一个
        //如果数组没有这个值，那么就会返回这个值在数组中按顺序应该存在的位置取负数再减一
        //binarySearch方法还可以限定查找索引范围（第一个包括，第二个不包括）
        Arrays.sort(arr_6);
        System.out.println("排序后的数组为" + Arrays.toString(arr_6));
        System.out.println("数字3在数组中的索引为：" + Arrays.binarySearch(arr_6, 3));//2
        System.out.println("数字1在数组中的索引为：" + Arrays.binarySearch(arr_6, 1));//0（实际上有0和1）
        System.out.println("数字5在数组中的索引为：" + Arrays.binarySearch(arr_6, 5));//-5（-4-1）
        System.out.println("限定范围后，数字1在数组中的索引为：" + Arrays.binarySearch(arr_6, 1, 2, 1));//0

        //数组常用操作：填充
        System.out.println("\n*******************************填充********************************");
        int[] arr_7 = {1, 1, 1};
        Arrays.fill(arr_7, 0, 1, 2);
        System.out.println(Arrays.toString(arr_7));
        Arrays.fill(arr_7, 3);
        System.out.println(Arrays.toString(arr_7));

        //数组常用操作6：复制数组
        System.out.println("\n*******************************截取********************************");
        //使用Arrays的copyOf静态方法
        //如果复制长度大于原数组长度，用该类型的默认值填充；如果复制长度小于原数组长度，就从数组的第一个元素开始截取
        int[] arr_8 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(Arrays.copyOf(arr_8, 2)));//[1,2]
        System.out.println(Arrays.toString(Arrays.copyOf(arr_8, 5)));//[1,2,3,4,0]

        //数组常用操作7：数组间比较
        System.out.println("\n*******************************数组间比较********************************");
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};
        int[] c = new int[]{1, 2, 3};
        int[] d = new int[]{1, 2, 3};
        System.out.println("== :" + (a == b));
        System.out.println("未覆盖的equals() :" + a.equals(b));
        System.out.println("覆盖后的equals() :" + Arrays.equals(a, b));
        System.out.println("== :" + (c == d));
        System.out.println("未覆盖的equals() :" + c.equals(d));
        System.out.println("覆盖后的equals() :" + Arrays.equals(c, d));
    }
}
