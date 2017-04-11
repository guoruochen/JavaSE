/**
 * @author 郭若辰
 * @create 2017-04-11 13:51
 */
public class Test06 {
    public static void main(String[] args) {
        int i = 5;
        System.out.println("i+=1的值为：" + (i += 1));//6
        System.out.println("i-=1的值为：" + (i -= 1));//5
        System.out.println("i*=2的值为：" + (i *= 2));//10
        System.out.println("i/=2的值为：" + (i /= 2));//5
        System.out.println("i%=2的值为：" + (i %= 2));//1

        byte b = 127;
        //!b = b + 1;
        b += 1;//+=运算符之所以可以通过编译，是在底层进行了自动强转（等同于b = (byte)(b+1)），但是实际上有弊端，可能造成溢出
        System.out.println(b);//-128  溢出
    }
}
