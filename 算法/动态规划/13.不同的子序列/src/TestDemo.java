/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-07-2021/7/29
 * Time: 14:00
 */
public class TestDemo {
    public static void main(String[] args) {

    }

    public static int numDistinct(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int[][] dp = new int[sLen + 1][tLen + 2];
        //F(i,0) = 1
        for (int i = 0; i <= sLen; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= tLen; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[sLen][tLen];
    }
}
