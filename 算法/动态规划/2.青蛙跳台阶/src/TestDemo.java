/**
 * Created with IntelliJ IDEA.
 * Description:
     一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶,3个台阶...n个台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * User: hong yaO
 * Date: 2021-07-2021/7/19
 * Time: 18:40
 */


public class TestDemo {
    public static void main(String[] args) {
        System.out.println(numWays(5));
    }
    public static int numWays(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n ; i++) {
            dp[i] = 2 * dp[i - 1];

        }
        return dp[n];
    }
}
