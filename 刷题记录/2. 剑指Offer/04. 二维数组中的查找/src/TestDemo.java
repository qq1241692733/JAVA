/**
 * Created with IntelliJ IDEA.
 * Description:
     在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
   请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 
    思路: 从右上角开始，小于向左找，大于向下找
 * User: hong yaO
 * Date: 2021-05-2021/5/17
 * Time: 23:47
 */
public class TestDemo {
    public static void main(String[] args) {

    }
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int i = 0;
        int j = matrix[i].length - 1;
        while (j >= 0 && i < matrix.length) {
            if (target < matrix[i][j]) {
                j --;
            }else if (target > matrix[i][j]) {
                i ++;
            }else if (target == matrix[i][j]) {
                return true;
            }
        }
        return false;
    }
}
