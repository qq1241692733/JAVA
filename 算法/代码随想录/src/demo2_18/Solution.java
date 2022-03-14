package demo2_18;

import demo2_11.TreeNode;

class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(3,
                null, new TreeNode(4)),
                new TreeNode(7, new TreeNode(6), new TreeNode(8)));

        TreeNode r =  deleteNode(root, 5);
        System.out.println(r.val);

    }
    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // 找到删除的结点了
            TreeNode left = root.left;
            if (root.right == null) {
                return root.left;
            } else if (root.left == null) {
                return root.right;
            } else {
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                cur.left = left;
                return root.right;
            }
        }
        return root;
    }
}