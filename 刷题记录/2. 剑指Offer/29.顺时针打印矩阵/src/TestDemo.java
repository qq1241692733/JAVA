import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/20
 * Time: 11:24
 */
public class TestDemo {
    public static void main(String[] args) {
        int[][] m = {{1,2,3}, {8,9,4}, {7,6,5}};
        int[][] m1 = {};
        System.out.println(Arrays.toString(spiralOrder(m1)));
    }

    public static int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int count = 0;
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        int[] res = new int[(right + 1) * (bottom + 1)];
        while (true) {
            for (int i = left; i <= right; i++) {
                res[count ++] = matrix[top][i];
            }
            top ++;
            if (top > bottom) break;

            for (int i = top; i <= bottom; i++) {
                res[count ++] = matrix[i][right];
            }
            right --;
            if (right < left) break;

            for (int i = right; i >= left; i--) {
                res[count ++] = matrix[bottom][i];
            }
            bottom --;
            if (bottom < top) break;

            for (int i = bottom; i >= top; i--) {
                res[count ++] = matrix[i][left];
            }
            left ++;
            if (left > right) break;;
        }
        return res;
    }
}
