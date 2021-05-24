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
            while () {
                for (int i = 2; i <= sqrt(num); i++) {
                    if (num % i == 0) {
                        num = num / i;
                    }
                }
            }
        }
    }

}
