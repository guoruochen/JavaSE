/**
 * @author 郭若辰
 * @create 2017-04-11 15:10
 */
public class Test07 {
    public static void main(String[] args) {
        int a = 3;
        float b = 3.0f;
        //进行比较之前，会先进行隐式类型转换
        System.out.println(a > b);//false
        System.out.println(a < b);//false
        System.out.println(a >= b);//true
        System.out.println(a <= b);//true
        System.out.println(a == b);//true
        System.out.println(a != b);//false
    }
}
