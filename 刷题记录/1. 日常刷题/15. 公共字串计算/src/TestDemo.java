import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
    输入：asdfas werasdfaswer
    输出：6
 * User: hong yaO
 * Date: 2021-05-2021/5/10
 * Time: 23:20
 */
public class TestDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();
        for (int i = 0; i < str2.length(); i++) {
            if (str2.charAt(i) == str1.charAt(i)) {
                for (int j = 1; j < str1.length(); j++) {
                    if (str1.charAt(j) != str2.charAt(i + j)) {
                        break;
                    }
                }
            }
        }
    }
}
