import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
     给定一个三角形 triangle ，找出自顶向下的最小路径和。

     每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于
    上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。

     示例 1：
     输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
     输出：11
     解释：如下面简图所示：
     2
     3 4
     6 5 7
     4 1 8 3
     自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
     示例 2：

     输入：triangle = [[-10]]
     输出：-10

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/triangle
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * User: hong yaO
 * Date: 2021-07-2021/7/24
 * Time: 11:33
 */
public class TestDemo {
    public static void main(String[] args) {

    }

    /**
        从顶到底
        状态：从（0，0）到 F(i,j) 最小路径和
        转移方程：F(i,0) = F(i-1,0) + a[i][0]
                F(i,i) = F(i-1,i-1) + a[i][i]
                F(i,j) = min{ F(i-1,j), F(i-1,j-1)} + a[i][j];
     初始状态：F(0,0) = a[0][0]
     返回结果 min{ F(row-1,j)}
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1])
                        + triangle.get(i).get(j);
            }
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int minTotal = dp[n - 1][0];
        for (int i = 1; i < n; i++) {
            minTotal = Math.min(minTotal, dp[n - 1][i]);
        }
        return minTotal;
    }

    /**
        从底到顶
        状态：F(i,j) 表示从点 (i, j)到底边的最小路径和 可看作 底边到点（i，j）最小路径和
        转移方程：F(i,j) = min{ F(i+1,j), F(i+1,j+1)} + a[i][j]
        初始状态：F(row - 1,j) = a[row - 1,j]
        返回结果：F(0,0)
     */
    public static int minimumTotal1(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n + 1][n + 1];

        for (int i = n-1; i >=0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1])
                        + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    // 空间优化 实测数组更快的多，次方法舍弃
    public static int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        for (int i = n-2; i >=0; i--) {
            for (int j = 0; j <= i; j++) {
                triangle.get(i).set(j, Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)) + triangle.get(i).get(j));
            }
        }
        return triangle.get(0).get(0);
    }

    /**
     *  空间复杂度 n^2 --> n
     *  在实际递推中我们发现，计算 dp[i][j]dp[i][j] 时，
     *  只用到了下一行的 dp[i + 1][j]dp[i+1][j] 和 dp[i + 1][j + 1]dp[i+1][j+1]。
     */

    public static int minimumTotal3(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
