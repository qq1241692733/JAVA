import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:获取一个数二进制序列中所有的偶数位和奇数位， 分别输出二进制序列
 * User: hong yaO
 * Date: 2020-12-2020/12/6
 * Time: 14:32
 */
public class TestDemo {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        System.out.println("奇数位");
        for(int i = 0; i <= 30; i +=2) {   //奇数位
            System.out.print(((num>>i)&1)+" ");
        }
        System.out.println("\n"+"偶数位");
        for (int i = 1; i <= 31; i +=2) {
            System.out.print(((num>>i)&1)+" ");
        }

    }
}
