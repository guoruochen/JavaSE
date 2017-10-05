/**
 * @author 郭若辰
 * @create 2017-04-10 16:23
 */
public class Test02 {
    public static void main(String[] args) {
        byte b = 1 + 2;//由于编译器确定1+2一定在byte的范围内，所以自动进行了强制类型转换，可以通过编译
        byte b1 = 1;
        //!b = b1 + 1;b1+1的结果是int，由于b1是变量，编译器无法判断b1+1是否在byte范围内，所以不能通过编译
        byte b2 = 2;
        //!b = b1 + b2;b1 + b2的结果是int，由于b1, b2都是是变量，编译器无法判断b1 + b2是否在byte范围内，所以不能通过编译
        final byte b3 = 1;
        b = b3 + 1;//虽然b3+1的结果也是int，但是由于b3是常量，所以编译器确定b3+1一定在byte的范围内，所以自动进行了强制类型转换，可以通过编译
    }
}
