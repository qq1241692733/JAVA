import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2020-12-2020/12/6
 * Time: 15:58
 */
public class TestDemo {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        int a=0;
        while (num!=0) {
            a=num%10;
            num/=10;
            System.out.println(a);
        }
    }
}
