import java.util.Arrays;

/**
 * @author 郭若辰
 * @create 2017-04-24 11:48
 */
public class Test22 {
    public static void main(String[] args) {
        //数组
        int[] arr_1 = {1, 2, 3};
        int[] arr_2 = {1, 2, 3};
        int[] arr_3 = new int[]{1, 2, 3};
        int[] arr_4 = new int[]{1, 2, 3};
        System.out.println("==和equals的数组验证：");
        System.out.println("arr_1 == arr_2: " + (arr_1 == arr_2));
        System.out.println("arr_1.equals(arr_2): " + (arr_1.equals(arr_2)));
        System.out.println("Arrays.equals(arr_1,arr_2): " + (Arrays.equals(arr_1, arr_2)));
        System.out.println("arr_3 == arr_4: " + (arr_3 == arr_4));
        System.out.println("arr_3.equals(arr_4): " + (arr_3.equals(arr_4)));
        System.out.println("Arrays.equals(arr_3,arr_4): " + (Arrays.equals(arr_3, arr_4)));
        System.out.println("Arrays.equals(arr_1,arr_4): " + (Arrays.equals(arr_1, arr_4)));

        //字符串
        String str_1 = "123";
        String str_2 = "123";
        String str_3 = new String("123");//本行代码只创建了一个对象，因为常量池里面已经有了"123"
        String str_4 = new String("123");
        System.out.println("\n==和equals的字符串验证：");
        System.out.println("str_1 == str_2: " + (str_1 == str_2));
        System.out.println("str_1.equals(str_2): " + (str_1.equals(str_2)));
        System.out.println("str_3 == str_4: " + (str_3 == str_4));
        System.out.println("str_3.equals(str_4): " + (str_3.equals(str_4)));

        //包装类
        Integer i1 = 1;
        Integer i2 = 1;
        Integer i3 = new Integer(1);
        Integer i4 = new Integer(1);
        Integer i5 = 128;
        Integer i6 = 128;
        Integer i7 = -129;
        Integer i8 = -129;
        System.out.println("\n==和equals()的包装类验证");
        System.out.println("i1 == i2: " + (i1 == i2));
        System.out.println("i1.equals(i2): " + (i1.equals(i2)));
        System.out.println("i3 == i4: " + (i3 == i4));
        System.out.println("i1.equals(i2): " + (i3.equals(i4)));
        System.out.println("i5 == i6: " + (i5 == i6));//已经超出了常量池的范围
        System.out.println("i5.equals(i6): " + (i3.equals(i4)));
        System.out.println("i7 == i8: " + (i7 == i8));//已经超出了常量池的范围
        System.out.println("i7.equals(i8): " + (i7.equals(i8)));

        //补充：StringBuffer和StringBuilder的equals()方法没有被覆盖
        StringBuffer s1 = new StringBuffer("1");
        StringBuffer s2 = new StringBuffer("1");
        StringBuilder s3 = new StringBuilder("1");
        StringBuilder s4 = new StringBuilder("1");
        System.out.println("\nStringBuffer和StringBuilder验证");
        System.out.println("s1 == s2: " + (s1 == s2));
        System.out.println("str_1.equals(s2): " + (str_1.equals(s2)));
        System.out.println("s3 == s4: " + (s3 == s4));
        System.out.println("s3.equals(s4): " + (s3.equals(s4)));
    }
}
