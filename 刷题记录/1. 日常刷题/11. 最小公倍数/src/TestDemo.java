import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-04-2021/4/18
 * Time: 23:45
 */
public class TestDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int x = A;
        int y = B;
        if (A < B) {
            int c = A;
            A = B;
            B = c;
        }
        while (B != 0) {
            int c = A;
            A = B;
            B = c%B;
        }
        System.out.println(x*y/A);
    }
}
