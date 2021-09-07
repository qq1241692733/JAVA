/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/7
 * Time: 18:58
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class TestDemo {
    public static void main(String[] args) {

    }
    public static boolean isBalanced(TreeNode root) {
        return (dfs(root) >= 0);
    }

    public static int dfs(TreeNode root) {
        if (root == null) return 0;
        int leftHigh = dfs(root.left);
        int rightHigh = dfs(root.right);
        if (Math.abs(rightHigh - leftHigh) > 1 || leftHigh == - 1 || rightHigh == -1) {
            return -1;
        }else {
            return Math.max(leftHigh, rightHigh) + 1;
        }
    }
}
