import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/3
 * Time: 23:23
 */
public class TestDemo {
    public static int[][] newPosition = {{0,1}, {1,0}};
    public static void main(String[] args) {
        System.out.println(movingCount(3, 2, 17));
        //System.out.println(get(23));
    }
    public static int movingCount(int m, int n, int k) {
        int res = 0;
        int[][] board = new int[m][n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        res ++;
        while (!queue.isEmpty()) {
            int code = queue.poll();
            int x = code / n;
            int y = code % n;
            for (int i = 0; i < 2; i++) {
                int nx = x + newPosition[i][0];
                int ny = y + newPosition[i][1];
                if (nx < m && ny < n && board[nx][ny] == 0 && get(nx)+get(ny) <= k) {
                    int nCode = nx * n + ny;  // 没看到 n
                    queue.offer(nCode);
                    res ++;
                    board[nx][ny] = 1;
                }
            }
        }
        return res;
    }
    public static int get(int num) {
        int ans = 0;
        while (num != 0) {
            ans += num % 10;
            num /= 10;
        }
        return ans;
    }
}
