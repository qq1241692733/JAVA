/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/8
 * Time: 20:28
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
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        while (true) {
            if (node.val > p.val && node.val > q.val) {
                node = node.left;
            }else if (node.val < p.val && node.val < q.val) {
                node = node.right;
            }else {
                break;
            }
        }
        return node;
    }
}
