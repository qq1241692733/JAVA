package day6_22;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-06-2021/6/22
 * Time: 1:05
 */
class Node {
    public char val;
    public Node left;
    public Node right;

    public Node(char val) {
        this.val = val;
    }
}
public class BinaryTree {
    public Node cre() {
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('E');
        Node I = new Node('F');
        Node J = new Node('G');
        Node K = new Node('G');
        E.left = F;
        E.right = G;
        F.left = H;
        F.right = I;
        G.left = J;
        G.right = K;
        return E;
    }

    // 前序遍历(递归)
    void preOrderTraversal(Node root) {
        if (root == null) return;
        System.out.println(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    // 中序遍历(递归)
    void inOrderTraversal(Node root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.println(root);
        inOrderTraversal(root.right);
    }

    // 后序遍历(递归)
    void postOrderTraversal(Node root) {
        if (root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(cur.val);
    }

}
