import javax.swing.*;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
        将任意10进制 m 转换成 n 进制数  (2 <= n <= 16)
 * User: hong yaO
 * Date: 2021-04-2021/4/14
 * Time: 23:16
 */
public class TestDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //int m = scanner.nextInt();
        String m = scanner.next();
        int n = scanner.nextInt();
        System.out.println(solve2(m, n));
    }

    // 10进制数 m 转换成n进制数
    public static String solve(int m, int n) {
        int flag = 0;
        String hex = "0123456789ABCDEF";
        if (m == 0 || n == 10) {
            return String.valueOf(m);
        }
        if (m < 0) {
            m = -m;
            flag = 1;
        }
        StringBuffer ret = new StringBuffer();
        while (m != 0) {
            ret.append(hex.charAt(m%n));
            m = m/n;
        }
        if (flag == 1) {
            return "-"+ret.reverse().toString();
        }else {
            return ret.reverse().toString();
        }
    }

    //n进制数 m 转10进制
    public static String solve2(String m, int n) {
        int len = m.length();
        int sum = 0;
        int i = 0;
        while (len != 0) {
            int num = m.charAt(len-1) - '0';
            if (num > 9) {
                num -= 39;
            }
            sum = sum + (int) Math.pow(n,i) * num;
            i ++;
            len --;
        }
        return String.valueOf(sum);
    }
}
