package demo2_17;

import demo2_11.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2022-02-2022/2/17
 * Time: 15:54
 */
class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(1), null);
        System.out.println(findMode(root));
    }
    static int maxCount = 0;
    static List<Integer> res = new ArrayList<>();
    static TreeNode pre = null;
    public static int[] findMode(TreeNode root) {
        dfs(root, 0);
        int[] resArr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }

    public static void dfs(TreeNode root, int count) {
        if (root == null) return;
        // 左
        dfs(root.left, count);
        // 中
        if (pre == null || root.val == pre.val) {
            count++;
        } else {
            count = 1;
        }
        if (count > maxCount) {
            res.clear();
            res.add(root.val);
            maxCount = count;
        } else if (count == maxCount) {
            res.add(root.val);
        }
        pre = root;
        // 右
        dfs(root.right, count);
    }
}