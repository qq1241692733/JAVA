package demo2_13;

import demo2_11.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2022-02-2022/2/13
 * Time: 20:47
 */
public class Solution {
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        List<String> res = new ArrayList<>();
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0;i < 4; i++) {
//            sb.append(i).append("->");
//        }
//        sb.append(4);
//        System.out.println(sb.toString());
//        res.add(sb.toString());
//        System.out.println(res);
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3));
        Solution solution = new Solution();
        System.out.println(solution.binaryTreePaths(root));
        StringBuilder sb = new StringBuilder();
    }

    StringBuilder path = new StringBuilder();
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root != null) dfs(root, res);
        return res;
    }
    public void dfs(TreeNode root, List<String> res) {
        path.append(root.val);
        if (root.left == null && root.right == null) {
            res.add(String.valueOf(path));
            return;
        }
        path.append("->");
        int len = path.length();
        if (root.left != null) {
            dfs(root.left, res);
            path.delete(len, path.length());
        }
        if (root.right != null) {
            dfs(root.right, res);
            path.delete(len, path.length());
        }
    }
}
