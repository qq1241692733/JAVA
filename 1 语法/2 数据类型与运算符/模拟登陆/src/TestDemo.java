import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:编写代码模拟三次密码输入的场景。 最多能输入三次密码，
 * 密码正确，提示“登录成功”,密码错误， 可以重新输 入，最多输入三次。三次均错，则提示退出程序
 * User: hong yaO
 * Date: 2020-12-2020/12/6
 * Time: 20:37
 */
public class TestDemo {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int count = 3;
        while(count != 0) {
            String str=scanner.nextLine();
            if(str.equals("123456")) {
                System.out.println("登录成功");
                break;
            }
            else {
                System.out.println("密码错误");
                count --;
            }
        }
    }

}
