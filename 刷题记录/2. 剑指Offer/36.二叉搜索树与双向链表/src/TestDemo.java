/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/4
 * Time: 20:59
 */
class Node {
    int val;
    Node left;
    Node right;
    Node() {}
    Node(int val) { this.val = val; }
    Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class TestDemo {
    public static void main(String[] args) {
        Node left = new Node(2, new Node(1), new Node(3));
        Node h = new Node(4, left, new Node(5));
        System.out.println(treeToDoublyList(h));
        System.out.println(1);
    }
    public static Node head;
    public static Node pre;
    public static Node treeToDoublyList(Node root) {
        if(root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    public static void dfs(Node root) {
        if (root == null) return;
        dfs(root.left);
        if (pre != null) {
            pre.right = root;
            root.left = pre;
        }else {
            head = root;
        }
        pre = root;
        dfs(root.right);
    }
}
