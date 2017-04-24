import java.util.Arrays;

/**
 * @author 郭若辰
 * @create 2017-04-24 11:39
 */
public class Test21 {
    public static void main(String[] args) {
        //数组
        int[] arr_1={1,2,3};
        int[] arr_2={1,2,3};
        int[] arr_3={4,5,6};
        System.out.println("三个数组调用未覆盖的toString方法得到的结果分别为："+arr_1+" "+arr_2+" "+arr_3);
        System.out.println("三个数组调用未覆盖hashCode方法得到的哈希值分别为："+arr_1.hashCode()+" "+arr_2.hashCode()+" "+arr_3.hashCode());
        System.out.println("三个数组调用覆盖后hashCode方法得到的哈希值分别为："+ Arrays.hashCode(arr_1)+" "+Arrays.hashCode(arr_2)+" "+Arrays.hashCode(arr_3));

        //字符串
        String str_1="123";
        String str_2="123";
        String str_3="abc";
        System.out.println("三个字符串调用覆盖后的toString方法得到的结果分别为："+str_1+" "+str_2+" "+str_3);
        System.out.println("三个字符串调用覆盖后hashCode方法得到的哈希值分别为："+str_1.hashCode()+" "+str_2.hashCode()+" "+str_3.hashCode());

        //包装类
        Integer i1=10;
        Integer i2=10;
        Integer i3=11;
        System.out.println("三个整数包装类调用覆盖后的toString方法得到的结果分别为："+i1+" "+i2+" "+i3);
        System.out.println("三个整数包装类调用覆盖后hashCode方法得到的哈希值分别为："+i1.hashCode()+" "+i2.hashCode()+" "+i3.hashCode());

        //普通类
        Test21 t=new Test21();
        System.out.println(t);
        System.out.println(t.hashCode());
        System.out.println(Integer.toHexString(t.hashCode()));
    }
}
