/**
 * @author 郭若辰
 * @create 2017-04-11 15:17
 */
public class Test08 {
    public static void main(String[] args) {
        //建议使用&&和||作为逻辑与和逻辑或，这样可以获得潜在的性能提升
        System.out.println((3 > 2) && (2 > 1));//true
        System.out.println((2 > 3) & (2 > 1));//false
        System.out.println((2 > 3) || (2 > 1));//true
        System.out.println((2 > 3) || (1 > 2));//false
        System.out.println((3 > 2) | (1 > 2));//true
        System.out.println((2 > 3) ^ (2 > 3));//false
        System.out.println((3 > 2) ^ (2 > 3));//true
        System.out.println(!true);//false
    }
}
