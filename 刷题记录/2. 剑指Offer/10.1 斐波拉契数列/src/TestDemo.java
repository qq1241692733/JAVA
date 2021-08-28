/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-07-2021/7/19
 * Time: 15:42
 */
public class TestDemo {
    public static void main(String[] args) {
        System.out.println(fib(10));
    }

    // 非递归
    public static int fib2(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int f1 = 0;
        int f2 = 1;
        int f3 = 1;
        for (int i = 1; i < n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
    // 递归 超时
    public static int fac(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return (fac(n - 1) + fac(n - 2)%1000000007);
    }
    // DP
    public static int fib(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }
}
