import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/4
 * Time: 19:13
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

public class TestDemo {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(-2);
        head.right = new TreeNode(-3);
        System.out.println(pathSum(head, -5));
    }
    public static LinkedList<Integer> list = new LinkedList<>();
    public static List<List<Integer>> pathSum(TreeNode root, int target) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        dfs(res, root, 0, target);
        return res;
    }
    public static void dfs(LinkedList<List<Integer>> res, TreeNode parent, int num, int target){
        if (parent == null) return;
        list.add(parent.val);
        num += parent.val;
//        if (num > target) {   // 这里如果是负数的话 就应该是小于
//            list.removeLast();
//            return;
//        };
        if (num == target && parent.left == null && parent.right == null) {
            res.add(new LinkedList<>(list));
        }
        dfs(res, parent.left, num, target);
        dfs(res, parent.right, num, target);
        list.removeLast();
    }
}
