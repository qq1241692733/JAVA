/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-08-2021/8/1
 * Time: 15:32
 */
public class TestDemo {
    private static final int[][] newPosition = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'}, {'1','1','0','1','0'},
                {'1','1','0','0','0'}, {'0','0','0','0','0'}};

        System.out.println(numIslands(grid));
    }
    public static int numIslands(char[][] grid) {
        int num = 0;
        int row = grid.length;
        int col = grid[0].length;
        int[][] book = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && book[i][j] == 0) {
                    Dfs(grid, book, i, j);
                    num ++;
                }
            }
        }
        return num;
    }

    private static void Dfs(char[][] grid, int[][] book, int i, int j) {
        book[i][j] = 1;
        for (int k = 0; k < 4; k++) {
            int ni = i + newPosition[k][0];
            int nj = j + newPosition[k][1];
            if (ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length && grid[ni][nj] == '1' && book[ni][nj] == 0) {
                Dfs(grid, book, ni, nj);
            }
        }
    }
}
