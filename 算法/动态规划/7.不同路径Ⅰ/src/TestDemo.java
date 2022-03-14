/**
 * Created with IntelliJ IDEA.
 * Description:
     一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
     机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
     问总共有多少条不同的路径？

     示例：
     输入：m = 3, n = 7
     输出：28

     输入：m = 3, n = 2
     输出：3

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/unique-paths
 * User: hong yaO
 * Date: 2021-07-2021/7/24
 * Time: 16:17
 */
public class TestDemo {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3,7));
    }

    /**
     * 状态（i,j）：从(0，0) 到（i,j）的路径个数
     * 状态方程：F(i,j) = F(i-1,j) + F(i,j-1)
     *         F(0,j) = F(0，j-1)
     *         F(i,0) = F(i-1,0)
     * 初始状态：F(0,0) = 1
     *
     * 优化：
     * 状态方程：F(i,j) = F(i-1,j) + F(i,j-1)
     * 初始状态：F(0,0) = F(0,j) = F(i,0) = 1
     * 返回结果：F(row-1,col-1)
     */
    public static int uniquePaths(int m, int n) {
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
        return dp[m - 1][n - 1];
    }

    /**
     * 优化
     * 状态（i,j）：从(0，0) 到（i,j）的路径个数
     * 状态方程：F(i,j) = F(i-1,j) + F(i,j-1)
     * 初始状态：F(0,j) = F(i,0) = 0
     *         F(0,1) = 1/  F(1,0) = 1
     * 返回结果：F(row,col)
     */
    public static int uniquePaths1(int m, int n) {
        int[][] dp =  new int[m+1][n+1];
        dp[0][1] =1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }
}
