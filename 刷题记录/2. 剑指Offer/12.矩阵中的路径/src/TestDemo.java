/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/3
 * Time: 21:38
 */
public class TestDemo {
    public static void main(String[] args) {
        char[][] b = {{'a','a'}};
        String s = "aaa";
        System.out.println(exist(b, s));
    }
    public static boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] user = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(board, user,  word, i, j, 0, row, col)) return true;
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, boolean[][] user, String word, int i, int j, int idx, int row, int col) {
        if (i < 0 || i >= row || j < 0 || j >= col || board[i][j] != word.charAt(idx) || user[i][j]) return false;
        if (idx == word.length() - 1) return true;
        user[i][j] = true;
        if (dfs(board, user, word, i, j + 1, idx + 1, row, col) ||
                dfs(board, user, word, i + 1, j, idx + 1, row, col) ||
                dfs(board, user, word, i, j - 1, idx + 1, row, col) ||
                dfs(board, user, word, i - 1, j, idx + 1, row, col)) {
            return true;
        }
        user[i][j] = false;
        return false;
    }
}
