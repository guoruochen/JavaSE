/**
 * @author 郭若辰
 * @create 2017-04-27 11:19
 */
public class Test34 {
    public static void main(String[] args) {

        bufferMethodTest_1();
        bufferMethodTest_2();
    }

    public static void bufferMethodTest_2() {
        StringBuffer sb = new StringBuffer("abcde");

        sb.delete(1, 3);
        System.out.println(sb);// ade

        sb.replace(1, 3, "kk");
        System.out.println(sb);// akk

        sb.setLength(2);// 可以改变字符串长度
        System.out.println(sb);// ak
        System.out.println(sb.length());// 2

        // 清空缓冲区
        sb.delete(0, sb.length());
    }

    public static void bufferMethodTest_1() {
        // 创建缓冲区对象
        StringBuffer sb = new StringBuffer();

        StringBuffer s1 = sb.append(4).append("kkk");
        sb.insert(1, "haha");

        System.out.println(sb);// 4hahakkk
        System.out.println(s1);// 4hahakkk
        System.out.println(sb == s1);// true
    }

}
