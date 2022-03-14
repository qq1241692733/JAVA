package demo2_11;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2022-02-2022/2/11
 * Time: 12:37
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(minDepth(root));
    }

    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
