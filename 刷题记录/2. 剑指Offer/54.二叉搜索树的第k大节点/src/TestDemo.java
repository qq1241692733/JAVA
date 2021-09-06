import javax.xml.soap.Node;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/5
 * Time: 19:31
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    TreeNode(int x, TreeNode left, TreeNode right) {
        val = x;
        this.left = left;
        this.right = right;
    }
}

public class TestDemo {
    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(2, new TreeNode(1),null);
        TreeNode node3 = new TreeNode(3, node2, new TreeNode(4));
        TreeNode node5 = new TreeNode(5, node3, new TreeNode(6));
        System.out.println(kthLargest(node5, 3));
    }
    public static int num = 0;
    public static int k1 = 0;
    public static int k = 0;
    public static int kthLargest(TreeNode root, int k) {
        k1 = k;
        dfs(root);
        return num;
    }
    public static void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        if (k1 == 0) {
            return;
        }else {
            k1 --;
            num = root.val;
        }
        dfs(root.left);
    }

}
