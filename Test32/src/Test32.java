import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;

import javax.print.DocFlavor;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author 郭若辰
 * @create 2017-04-26 10:44
 */
public class Test32 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //创建字符串
        String str_1 = "123";//由于"123"是字面量，它会在类首次加载时被放入运行时常量池
        String str_2 = new String("123");//此时运行时常量池之中已经有了一个"123",所以本行语句只会在堆上创建一个该字符串的拷贝对象
        String str_test = new String("abc");//此时运行时常量池里面并没有"abc"，所以本行语句会先在常量池里面创建一个"abc"，然后再在堆上创建一个拷贝字符串
        byte[] arr_1 = {65, 66, 67, 68, 69};
        char[] arr_2 = {65, 66, '3', 'q', 'r'};
        String str_3 = new String(arr_1);//ABCDE    字节数组 -->字符串
        String str_4 = new String(arr_1, 2, 3);//CDE
        String str_5 = new String(arr_2);//AB3qr    字符数组 -->字符串
        String str_6 = new String(arr_2, 1, 4);//B3qr
        System.out.println(str_3);
        System.out.println(str_4);
        System.out.println(str_5);
        System.out.println(str_6);
        System.out.println(str_1 + null);//123null  面试有可能出现

        /*
         * 实际上，如果希望使用运行时常量池中的字符串而不是堆上的，可以使用String的intern()方法
         * 当调用String类的intern()方法时，如果常量池中已经包括此字符串，则将其返回
         * 否则，将此字符串添加到运行时常量池中，并返回此字符串的引用
         */
        String ss = new String("kkk");//分别在常量池和堆创建"kkk"，ss指向的是堆中的"kkk"
        String sss = ss.intern();//此时常量池中已经有"kkk"了，所以将"kkk"返回，sss指向的是常量池中的"kkk"
        System.out.println(ss == sss);//false
        System.out.println("xyz".intern());//xyz  此时常量池中没有"xyz"，所以会将"xyz"添加到运行时常量池中，并将其返回

        /*
        String不变性：字符串一旦被初始化就不会被改变
        之所以字符串对象可以放进常量池，究其原因就是因为String具有不变性
        String类中每一个看起来会修改字符串值的API，实际上都是创建了一个新的字符串对象
         */
        String str_7 = "haha";
        String str_8 = str_7 + "!";//这实际上是新创建了一个字符串haha!，并赋给str_8引用

        //String常用操作1：获取
        String str = "32123123";
        int length = str.length();//获取字符串长度
        char ch = str.charAt(0);//获取指定索引的字符   字符串-->字符
        //!char c = str_1.charAt(10); StringIndexOutOfBoundsException  这是个RuntimeException
        int a = str.indexOf('2');//获取字符在字符串中的索引，如果包含此字符，返回其第一次出现时的索引
        int b = str.indexOf('4');//获取字符在字符串中的索引，如果不包含此字符，返回-1
        int c = str.indexOf('3', 1);//获取字符在字符串中的索引（从指定索引开始找），如果包含此字符，返回其第一次出现时的索引
        int d = str.indexOf("123");//获取字符串在字符串中的索引，如果包含此字符串，返回其首字符出现时的索引
        int e = str.indexOf("123", 3);//获取字符串在字符串中的索引（从指定索引开始找），如果包含此字符串，返回其首字符出现时的索引
        int a1 = str.lastIndexOf('1');//从后向前查找，获取字符在字符串中的索引，如果包含此字符，返回其第一次出现时的索引
        int b1 = str.lastIndexOf('4');//从后向前查找，获取字符在字符串中的索引，如果不包含此字符，返回-1
        int c1 = str.lastIndexOf('1', 3);//从后向前查找，获取字符在字符串中的索引（从指定索引开始找），如果包含此字符，返回其第一次出现时的索引
        int d1 = str.lastIndexOf("123");//从后向前查找，获取字符串在字符串中的索引，如果包含此字符串，返回其第一次出现时的索引
        int e1 = str.lastIndexOf("123", 3);//从后向前查找，获取字符串在字符串中的索引，如果包含此字符串，返回其第一次出现时的索引
        int x = str.indexOf("");//字符串前后都被空字符包起来了
        int y = str.lastIndexOf("");//字符串前后都被空字符包起来了
        String substr_1 = str.substring(2);//获取子字符串（指定起始索引）
        String substr_2 = str.substring(2, 4);//获取子字符串（指定起始索引和结束索引，不包括结束索引）
        System.out.println("length=" + length);
        System.out.println("ch=" + ch);
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        System.out.println("c=" + c);
        System.out.println("d=" + d);
        System.out.println("e=" + e);
        System.out.println("a1=" + a1);
        System.out.println("b1=" + b1);
        System.out.println("c1=" + c1);
        System.out.println("d1=" + d1);
        System.out.println("e1=" + e1);
        System.out.println("x=" + x);
        System.out.println("y=" + y);
        System.out.println("substr_1=" + substr_1);
        System.out.println("substr_2=" + substr_2);

        //String常用操作2：转换
        String s = "哈哈,a,b,Sss";
        String[] arr_3 = s.split(",");//将字符串变成String数组（字符串的切割）
        char[] arr_4 = s.toCharArray();//将字符串变为字符数组   字符串-->字符数组
        byte[] arr_5 = s.getBytes();//将字符串变为字节数组     字符串-->字节数组
        String s1 = s.toUpperCase();//大写转换
        String s2 = s.toLowerCase();//小写转换
        String s3 = s.replace('s', 'a');//将字符串中的内容进行替换
        String s4 = s.replace('a', 'a');//将字符串中的内容进行替换
        String s5 = "   asd    ".trim();//将字符串两端的空白字符删除（如果用户输入的信息有空格，可以用此方法处理）
        String s6 = "abc".concat("123");//连接字符串（与+效果相同，建议用+）
        String s7 = String.valueOf(4) + 1;//将参数转变为字符串
        System.out.println(Arrays.toString(arr_3));
        System.out.println(Arrays.toString(arr_4));
        System.out.println(Arrays.toString(arr_5));
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s4 == s);//true  如果没有发生替换，则返回原始的字符串
        System.out.println(s5);
        System.out.println(s6);
        System.out.println(s7);

        //String常用操作3：判断（重要）
        String m = "abc123abc";
        String n = "abc123ABC";
        System.out.println(m.equalsIgnoreCase(n));
        System.out.println(m.equals(n));
        System.out.println(n.contains("abc"));
        System.out.println(n.startsWith("abc"));
        System.out.println(n.endsWith("ABC"));

        //String常用操作4：比较（从前往后按照Unicode值比较字符串的字符大小）
        System.out.println("abc".compareTo("abd"));
        System.out.println("abc".compareTo("abb"));
        System.out.println("abc".compareTo("abc"));

        /*
        * 练习：利用字符串与字符之间的转换，将字符串中的小写字母变换为大写字母
        */
        //第一种方式：使用charAt()和String构造函数
        String lower = "abcdef123~呵呵";
        char[] buf_1 = new char[lower.length()];
        for (int i = 0; i < lower.length(); i++) {
            char cha = lower.charAt(i);
            if (cha >= 'a' && ch <= 'z') {
                ch -= 32;
            }
            buf_1[i] = cha;
        }
        System.out.println(new String(buf_1));
        //第二种方式：使用toCharArray()和String构造函数
        char[] buf_2 = lower.toCharArray();
        for (int i = 0; i < buf_2.length; i++) {
            if (buf_2[i] >= 'a' && buf_2[i] <= 'z') {
                buf_2[i] -= 32;
            }
        }
        System.out.println(new String(buf_2));
    }
}
