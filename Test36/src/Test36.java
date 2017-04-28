import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author 郭若辰
 * @create 2017-04-28 10:38
 */
public class Test36{
    private JFrame frame;
    private JButton button;

    public void gui(){
        frame = new JFrame("匿名内部类的使用");
        button = new JButton("这只是个按钮");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(button);
        show();
    }

    private void show() {
        int a  = 1;
        final int b = 2;
        //匿名内部类
        //前提：匿名内部类必须继承或实现某外部类或接口，在这里就是实现了ActionListener接口
        //格式：new 父类/接口(){子类/实现类内容}
        //通常使用场景：当方法参数是接口类型，且接口中的方法不超过三个，可以使用匿名内部类作为实参进行传递
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.setText("I'm clicked");
                System.out.println(a);
                System.out.println(b);//JDK1.7时，匿名内部类只能访问方法的final局部变量，JDK1.8取消了这个限制
            }
        });
    }

    public static void main(String[] args) {
        new Test36().gui();
    }
}
