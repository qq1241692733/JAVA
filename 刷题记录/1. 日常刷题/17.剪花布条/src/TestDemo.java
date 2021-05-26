import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 分割 str1 能得到几个 str2
    输入：abcde a3   aaaaaa aa
    输出：0          3
 * Date: 2021-05-2021/5/25
 * Time: 23:13
 */
public class TestDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int sum = 0;
            for (int i = m; i <= n ; i++) {
                sum += fib(i);
            }
            System.out.println(sum);
        }
    }

    public static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static int fib1(int n) {
        int f1 = 1;
        int f2 = 1;
        int f3 = 1;
        for (int i = 3; i <= n ; i++) {
            f3 = f1+f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }


    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int count = 0;
            String str1 = scanner.next();
            String str2 = scanner.next();
            for (int i = 0; i < str1.length(); ) {
                if (str1.charAt(i) == str2.charAt(0)) {
                    int n = i;
                    int j = 0;
                    while (j < str2.length() && n < str1.length() && str1.charAt(n) == str2.charAt(j)) {
                        n ++;
                        j ++;
                    }
                    if (j == str2.length()) {
                        count ++;
                        i = n;
                    }
                }
            }
            System.out.println(count);
        }
    }
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int count = 0;
            String str1 = scanner.next();
            String str2 = scanner.next();
            for (int i = 0; i <= str1.length() - str2.length(); ) {
                if (str1.substring(i, i + str2.length()).equals(str2)) {
                    count++;
                    i += str2.length();
                } else {
                    i++;
                }
            }
            System.out.println(count);
        }
    }

}
