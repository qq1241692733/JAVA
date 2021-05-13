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
        //str2: werasdfaswer    i
        //str1: wedfas          j
        String str1 = scanner.next();
        String str2 = scanner.next();
        if (str1.length() > str2.length()) {
            String  s = str1;
            str1 = str2;
            str2 = s;
        }
        int count = 0;
        for (int i = 0; i < str2.length(); i++) {
            int s1 = 0;
            for (int j = 0; j < str1.length(); j++) {
                int m = i;
                int n = 0;
                while (str1.charAt(i) == str2.charAt(j)) {
                    
                }
            }
        }
    }
}
