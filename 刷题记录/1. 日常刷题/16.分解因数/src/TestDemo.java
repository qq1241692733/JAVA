import java.util.Scanner;

import static com.sun.org.apache.xalan.internal.lib.ExsltMath.sqrt;

/**
 * Created with IntelliJ IDEA.
 * Description:
        输入：10  18
        输出：10 = 2 * 5     18 = 2 * 3 * 3
 * User: hong yaO
 * Date: 2021-05-2021/5/24
 * Time: 0:13
 */
public class TestDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            System.out.print(String.format("%d = ",num));
            int i = 2;
            int n = num;
            while (i <= sqrt(num)) {
                if (num % i == 0) {
                    System.out.print(i + " * ");
                    num = num/i;
                }else {
                    i ++;
                }
            }
            System.out.println(num);
        }
    }

}
