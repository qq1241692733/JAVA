import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
    写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。
        例如: 输入：abcd  输出：dcba
 * User: hong yaO
 * Date: 2021-05-2021/5/10
 * Time: 23:05
 */
public class TestDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        for (int i = str1.length()-1; i >= 0; i--) {
            System.out.print(str1.charAt(i));
        }
    }
}
