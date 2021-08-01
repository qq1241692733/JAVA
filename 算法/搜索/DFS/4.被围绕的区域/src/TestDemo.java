import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-07-2021/7/31
 * Time: 16:25
 */
public class TestDemo {
    static int[][] newPosition = new int[][]{{0,1}, {-1,0}, {0,-1}, {1,0}};
    public static void main(String[] args) {
        char[][] board = {{'O','X','X'}, {'X','O','X'}, {'X','X','X'}};
        for(char[] arr : board) {
            System.out.println(Arrays.toString(arr));
        }
        board = solve(board);
        System.out.println("-------------------------------");
        for(char[] arr : board) {
            System.out.println(Arrays.toString(arr));
        }
    }

    private static char[][] solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < col; i++) {
            if (board[0][i] == 'O') {
                Dfs(board,0,i);
            }
            if (board[row - 1][i] == 'O') {
                Dfs(board,row - 1,i);
            }

        }
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                Dfs(board, i,0);
            }
            if (board[i][col - 1] == 'O') {
                Dfs(board, i, col - 1);
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        return board;
    }

    private static void Dfs(char[][] board, int x, int y) {
        board[x][y] = '*';
        for (int i = 0; i < 4; i++) {
            int nx = x + newPosition[i][0];
            int ny = y + newPosition[i][1];
            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && board[nx][ny] == 'O') {
                Dfs(board,nx,ny);
            }
        }
    }


//    public static char[][] solve(char[][] board) {
//        int row = board.length;
//        int col = board[0].length;
//        int[][] book = new int[row][col];
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                if (book[i][j] == 0) {
//                    Dfs(board, book, i, j);
//                }
//            }
//        }
//        return board;
//    }
//    public static void Dfs(char[][] board, int[][] book,int x, int y) {
//        if (board[x][y] == 'O') {
//            int cur = 0;
//            for (int i = 0; i < 4; i++) {
//                int newX = x + newPosition[i][0];
//                int newY = y + newPosition[i][1];
//                if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length) {
//                    Dfs(board, book, newX, newY);
//                    book[newX][newY] = 1;
//                    if (board[newX][newY] == 'O') {
//                        if (newX == 0 || newX == board.length - 1 || newY == 0 || newY == board[0].length - 1) {
//                            cur = 1;
//                        }
//                    }
//                }
//
//                if (cur == 0 && newX > 0 && newX < board.length - 1 && newY > 0 && newY < board[0].length - 1) {
//                    board[newX][newY] = 'X';
//                }
//            }
//        }
//    }
}
