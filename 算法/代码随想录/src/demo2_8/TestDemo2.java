package demo2_8;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2022-02-2022/2/8
 * Time: 17:35
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(){}
    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class TestDemo2 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        //inOrderIteration(root);
        List<Integer> list = postorderTraversal(root);
        System.out.println(list);
    }
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.add(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (cur.right != null && cur.right != prev) {
                    // 有右子树并且右子树没遍历，需放回根结点到栈中
                    stack.push(cur);
                    // 接下来遍历右子树
                    cur = cur.right;
                } else {
                    // 没有右子树，或者右子树被遍历过，
                    res.add(cur.val);
                    // 更新前指针
                    prev = cur;
                    // 以该结点的子树都已遍历，下次需要从栈中取父亲结点向上遍历，所以 cur == null
                    cur = null;
                }
            }
        }
        return res;
    }
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }
    public static void preorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        preorder(root.right, list);
        preorder(root.left, list);
    }
    public static void inOrderIteration(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode cur = head;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);

                cur = cur.left;
            }
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            if (node.right != null) {
                cur = node.right;
            }
        }
    }

}
