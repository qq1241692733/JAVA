package demo2_10;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2022-02-2022/2/10
 * Time: 22:19
 */
public class Solution {
    static List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.out.println(levelOrder(root));
        Queue<TreeNode> queue = new ArrayDeque<>();
        Collections.reverse(res);
        System.out.println(res);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        chackFun(root, 0);
        return res;
    }
    public static void chackFun(TreeNode root, int deep) {
        if (root == null) return;
        deep++;
        if (res.size() < deep) {
            List<Integer> list = new ArrayList<>();
            res.add(list);
        }
        res.get(deep - 1).add(root.val);
        chackFun(root.left, deep);
        chackFun(root.right, deep);
    }
}

