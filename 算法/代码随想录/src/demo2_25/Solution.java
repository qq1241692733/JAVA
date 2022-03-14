package demo2_25;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2022-02-2022/2/25
 * Time: 15:16
 */
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.uniquePaths(3, 2));
    }
    public int backPackII(int m, int[] A, int[] V) {
        int row = A.length;
        if (row == 0 || m == 0) return 0;
        int[] dp = new int[row + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = m; j > A[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - A[i - 1]] + V[i - 1]);
            }
        }
        return dp[m];
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n- 1];
    }
}
