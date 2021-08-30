/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-08-2021/8/30
 * Time: 18:53
 */
public class TestDemo {
    public static void main(String[] args) {
        int num = 502;
        System.out.println(translateNum(num));
    }

    /**
     * 状态：f(n): 前 n 个数字的不同翻译方法
     * 状态方程：if (后两个数字小于25)，f(n) = f(n - 1) + f(n - 2)
     *              else  f(n) = f(n - 1);
     * 初始状态：f(0) = 0;
     * 返回：f(n);
     */
    public static int translateNum(int num) {
        String s = String.valueOf(num);
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            int n = Integer.parseInt(s.substring(i - 2, i));
            if (n <= 25 && n >= 10) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[s.length()];
    }
}
