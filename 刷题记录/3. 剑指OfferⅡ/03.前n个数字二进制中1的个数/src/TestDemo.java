import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/21
 * Time: 12:35
 */
public class TestDemo {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5)));
    }

    /**
     * dp[i] = dp[i >> 1]
     *  解释：
     *     观察下边数的二进制数的变化
     *      1,3,5,7,9 -> 2,4,6,8,10
     *      2 -> 4 -> 8 -> 16
     *      6 -> 12 -> 24 -> 48
     *    无论奇数还是偶数 n，2 * n 的二进制比 n 尾部多个0
     *
     */
    public static int[] countBits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                dp[i] = dp[i - 1] + 1;
            }else {
                dp[i] = dp[i >> 1];
            }
        }
        return dp;
    }
}
