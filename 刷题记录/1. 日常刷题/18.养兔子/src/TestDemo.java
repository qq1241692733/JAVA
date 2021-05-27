import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 题目描述
    —只成熟的兔子每天能产下一胎兔子。每只小兔子的成熟期是—天。某人领养了一只小兔子，请问第N天以后，他将会得到多少只兔子。
 输入描述:
    测试数据包括多组，每组一行，为整数n ( 1≤n<90)。
 输出描述:
    对应输出第n天有几只兔子〈假设没有兔子死亡现象)。

 解题思路：斐波那契
 * User: hong yaO
 * Date: 2021-05-2021/5/26
 * Time: 23:56
 */
public class TestDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int day = scanner.nextInt();
            System.out.println(fib2(day+1));
        }
    }
    public static int fib1(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib1(n - 1) + fib1(n - 2);
    }
    public static long fib2(int n) {
        long f1 = 1;
        long f2 = 1;
        long f3 = 1;
        for (int i = 3; i <= n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
}
