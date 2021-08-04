import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-08-2021/8/4
 * Time: 21:40
 */
public class TestDemo {
    public static int[][] newPosition = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public static void main(String[] args) {
        int[][] grid = {{2,1,1}, {1,1,0}, {0,1,1}};
        System.out.println(orangesRotting(grid));
    }
    public static int orangesRotting(int[][] grid) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    int code = j + i * col;
                    queue.offer(code);
                    map.put(code, 0);
                }
            }
        }
        while (!queue.isEmpty()) {
            int code = queue.poll();
            int x = code / col;
            int y = code % col;
            for (int i = 0; i < 4; i++) {
                int nx = x + newPosition[i][0];
                int ny = y + newPosition[i][1];
                if (nx >= 0 && nx < row && ny >= 0 && ny < col && grid[nx][ny] == 1) {
                    grid[nx][ny] = 2;
                    int nCode = ny + nx * col;
                    queue.offer(nCode);
                    map.put(nCode, map.get(code) + 1);
                    count = map.get(nCode);
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return count;
    }
}
