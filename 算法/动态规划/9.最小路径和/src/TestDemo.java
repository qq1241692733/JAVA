/**
 * Created with IntelliJ IDEA.
 * Description:
     给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     说明：每次只能向下或者向右移动一步。

     输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
     输出：7
     解释：因为路径 1→3→1→1→1 的总和最小。

     https://leetcode-cn.com/problems/minimum-path-sum/
 * User: hong yaO
 * Date: 2021-07-2021/7/26
 * Time: 11:32
 */
public class TestDemo {
    public static void main(String[] args) {
        int[][] a = new int[][]{{1,3,1}, {1,5,1}, {4,2,1}};
        System.out.println(minPathSum(a));
    }

    /**
     * 状态（i,j）最小路径和
     * 状态方程：F(i,j) = min{ F(i,j-1), F(i-1,j)} + a(i,j)
     *         F(0,j) = F(0,j-1) + a(0,j)
     *         F(i,0) = F(i-1,0) + a(i,0)
     * 返回结果：F(i-1,j-1)
     */
    public static int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }
}
