/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/7
 * Time: 9:30
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
    public static int deep = 0;
    public static int maxDepth(TreeNode root) {
        int num = 0;
        dfs(root,num);
        return deep;
    }

    private static void dfs(TreeNode root, int count) {
        if (root == null) {
            deep = Math.max(deep, count);
            return;
        }
        count ++;
        dfs(root.left, count);
        dfs(root.right, count);
    }

}
