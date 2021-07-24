/**
 * Created with IntelliJ IDEA.
 * Description:
     一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
     网格中的障碍物和空位置分别用 1 和 0 来表示。

     输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
     输出：2

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/unique-paths-ii

 * User: hong yaO
 * Date: 2021-07-2021/7/24
 * Time: 17:17
 */
public class TestDemo {
    public static void main(String[] args) {
        int[][] ob= new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        int[][] a = new int[][]{{0,1},{0,0}};
        //System.out.println(uniquePathsWithObstacles(ob));
        System.out.println(uniquePathsWithObstacles1(a));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = 1;
            }else {
                break;
            }
        }

        for (int i = 0; i < col; i++) {
            if (obstacleGrid[0][i] == 0) {
                dp[0][i] = 1;
            }else {
                break;
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = dp[i][j - 1] + dp[i -1][j];
                }
            }
        }
        return dp[row - 1][col - 1];
    }

    /**
        我真的服了
     */
    public static int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row + 1][col + 1];
        dp[0][1] = 1;
        for (int i = 1; i <= row ; i++) {
            for (int j = 1; j <= col; j++) {
                if (obstacleGrid[i -1 ][j - 1] == 1) {
                    dp[i][j] = 1;
                }
            }
        }

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (obstacleGrid[i - 1][j - 1] == 1) {
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = dp[i][j - 1] + dp[i -1][j];
                }
            }
        }
        return dp[row][col];
    }
}
