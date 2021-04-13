import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
    输入: i like you
    输出: you like i
 * User: hong yaO
 * Date: 2021-04-2021/4/13
 * Time: 10:05
 */
public class TestDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] s = str.split(" ");
        for (int i = s.length -1; i >= 0; i--) {
            System.out.print(s[i]);
            if (i > 0) {
                System.out.print(" ");
            }
        }
    }
}
