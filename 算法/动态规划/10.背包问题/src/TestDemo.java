/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-07-2021/7/26
 * Time: 12:48
 */
public class TestDemo {
    public static void main(String[] args) {

    }

    /**
     * 状态 F(i,j): 前 i个物品放入大小为 j的背包中所获得的最大价值
     * 递推关系：当前背包放不下新增物品时 A(i-1) < j:
     *              F(i,j) = F(i-1,j)
     *     放得下时： F(i,j) = max{ (F(i-1, j), F(i-1, F(j - A(i-1))) + V(i - 1)}
     *     A(i-1):  新增物品的大小
     *     V(i-1):  新增物品的价格
     *
     * 初始状态：F(i,0) = F(0,j) = 0
     * 返回值：F(i,j)
     */
    public static int backPackII(int m, int[] A, int[] V) {
        int row = A.length;
        if (row == 0 || m == 0) return 0;
        int[][] dp = new int[row + 1][m + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= m; j++) {
                if (A[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - A[i - 1]] + V[i - 1]);
                }
            }
        }
        return dp[row][m];
    }

    /**
     * 空间优化 O(n^2) -> O(n)
     *     从后向前更新
     * 状态方程：
     * */
    public static int backPackII1(int m, int[] A, int[] V) {
        int[] dp = new int[m + 1];
        // ...
        return dp[m];
    }
}
