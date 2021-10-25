import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/25
 * Time: 10:24
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class CBTInserter {
    private TreeNode root = null;
    private Queue<TreeNode> queue = null;
    public CBTInserter(TreeNode root) {
        this.root = root;
        queue = new LinkedList<>();
        //queue.offer(root);

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            // 织添加最后一行
            if (node.left == null || node.right == null) {
                queue.offer(node);
            }
            if (node.left != null) {
                q.offer(node.left);
            }
            if (node.right != null) {
                q.offer(node.right);
            }
        }
    }

    public int insert(int v) {
            TreeNode node = queue.peek();
            TreeNode newNode = new TreeNode(v);
            queue.offer(newNode);
            if (node.left == null) {
                node.left = newNode;
            }else {
                node.right = newNode;
                queue.poll();
            }
            return node.val;
    }

    public TreeNode get_root() {
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2,new TreeNode(4),null), new TreeNode(3));
        CBTInserter cbtInserter = new CBTInserter(root);
        System.out.println(cbtInserter.insert(5));
        System.out.println(cbtInserter.get_root().val);
    }
}
