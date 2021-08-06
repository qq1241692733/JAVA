import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
     链接：https://www.nowcoder.com/questionTerminal/bd891093881d4ddf9e56e7cc8416562d
     读入一个字符串str，输出字符串str中的连续最长的数字串
     输入描述:
     个测试输入包含1个测试用例，一个字符串str，长度不超过255。
     输出描述:
     在一行内输出str中里连续最长的数字串。

     示例1
         输入
         abcd12345ed125ss123456789
         输出
         123456789

 * User: hong yaO
 * Date: 2021-08-2021/8/6
 * Time: 22:40
 */
public class TestDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int i = 0;
        int end = 0;
        int max = 1;
        while (i < str.length()) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                int len = 1;
                i ++;
                while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    i ++;
                    len ++;
                }
                if (max < len) {
                    end = i;
                    max = len;
                }
            }else {
                i ++;
            }
        }
        System.out.println(str.substring(end - max, end));
    }
}
