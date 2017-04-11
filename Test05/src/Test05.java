/**
 * @author 郭若辰
 * @create 2017-04-11 13:24
 */
public class Test05 {
    public static void main(String[] args) {
        int a = 1;
        int b;
        b = a++;//首先内存会划出一块临时存储区域，拷贝a的值并进行存储（假设这个是temp），然后再划出一块临时计算区域计算a+1的值，然后将计算结果赋给a，最后将临时存储区域存放的temp赋给b
        System.out.println("a=" + a + ",b=" + b);//a=2,b=1
        b = ++a;//先将a的值加1，再将a的值赋给b
        System.out.println("a=" + a + ",b=" + b);//a=3,b=3
        b = a--;//同理a++
        System.out.println("a=" + a + ",b=" + b);//a=2,b=3
        b = --a;//同理++a
        System.out.println("a=" + a + ",b=" + b);//a=1,b=1
        int i = 1;
        i = i++;
        System.out.println("i=" + i);//i=1，原理同上
    }
}
