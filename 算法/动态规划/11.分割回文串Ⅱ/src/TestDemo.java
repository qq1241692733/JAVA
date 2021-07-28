import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-07-2021/7/27
 * Time: 9:36
 */
public class TestDemo {
    public static void main(String[] args) {
        System.out.println(minCut1("aab"));
    }

    public static int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = i - 1;
        }
        for (int i = 2; i <= n; i++) {
            if (isPal(s, 1, i)) {
                dp[i] = 0;
                continue;
            }
            for (int j = 2; j <= i; j++) {
                if (isPal(s, j, i)) {
                    dp[i] = Math.min(dp[j - 1] + 1, dp[i]);
                }
            }
        }
        return dp[n];
    }

    public static boolean isPal(String s, int start, int end) {
        char[] str = s.toCharArray();
        while (start < end) {
            if (s.charAt(start - 1) != s.charAt(end - 1)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    /**
     * 时间复杂度 O(n^3)
     */
    public static int minCut1(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            dp[i] = i - 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (isPal(s, j, i)) {
                    dp[i] = Math.min(dp[j - 1] + 1, dp[i]);
                }
            }
        }
        return dp[n];
    }

    /**
     * 状态F(i,j): 区间是否为回文串
     * 转移方程: F(i,j): [i+1, j-1] 是否为回文串 && s[i] == s[j]
     * F(i,i): true
     */
    public static boolean[][] getMat(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (j == i + 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    dp[i][j] = (dp[i + 1][j - 1]) && (s.charAt(i) == s.charAt(j));
                }
            }
        }
        return dp;
    }
    public static int minCut2(String s) {
        int n = s.length();
        boolean[][] mat = getMat(s);
        int[] dp = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            dp[i] = i - 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (mat[j][i - 1]) {
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                }
            }
        }
        return dp[n];
    }
}