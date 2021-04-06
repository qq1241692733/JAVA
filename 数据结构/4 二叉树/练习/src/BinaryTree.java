import javax.sound.midi.Soundbank;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-01-2021/1/26
 * Time: 9:43
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
//    public Node cre() {
//        Node A = new Node('A');
//        Node B = new Node('B');
//        Node C = new Node('C');
//        Node D = new Node('D');
//        Node E = new Node('E');
//        Node F = new Node('F');
//        Node G = new Node('G');
//        Node H = new Node('H');
//        A.left = B;
//        A.right = C;
//        B.left = D;
//        B.right = E;
//        C.left = F;
//        C.right = G;
//        E.right = H;
//        return A;
//    }

    public Node cre() {
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');
        Node I = new Node('I');
        Node J = new Node('J');
        Node K = new Node('K');
        E.left = F;
        E.right = G;
        F.left = H;
        F.right = I;
        G.left = J;
        G.right = K;
        return E;
    }
    // 前序遍历
    void preOrderTraversal(Node root) {
        if (root == null) return;
        System.out.print(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    // 中序遍历
    void inOrderTraversal(Node root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.val);
        inOrderTraversal(root.right);
    }
    // 后序遍历
    void postOrderTraversal(Node root) {
        if (root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val);
    }
    // 遍历思路-求结点个数
    static int size = 0;
    void getSize1(Node root) {
        if (root != null) {
            size ++;
        } else return;
        getSize1(root.left);
        getSize1(root.right);
    }
    // 子问题思路-求结点个数
    int getSize2(Node root) {
        return  1;
    }
    // 遍历思路-求叶子结点个数
    static int leafSize = 0;
    void getLeafSize1(Node root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            leafSize ++;
        }
        getLeafSize1(root.right);
        getLeafSize1(root.left);
    }
    // 子问题思路-求叶子结点个数
    int getLeafSize2(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeafSize2(root.right) + getLeafSize2(root.left);
    }
    // 子问题思路-求第 k 层结点个数
    int getKLevelSize(Node root, int k) {
        if ( root == null) return 0;
        if (k == 1) {
            return 1;
        }
        return getKLevelSize(root.left,k-1) + getKLevelSize(root.right,k-1);
    }
    // 获取二叉树的高度
    int getHeight(Node root) {
        return 1;
    }

    //层数遍历
    void levelOrderTraversal(Node root) {
        if(root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node cur =queue.poll();
            System.out.print(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }
// 查找 val 所在结点，没有找到返回 null
// 按照 根 -> 左子树 -> 右子树的顺序进行查找
// 一旦找到，立即返回，不需要继续在其他位置查找
    Node find(Node root, char val) {
        if (root == null) return null;
        if (root.val == val) {
            return root;
        }
        Node ret = find(root.left,val);
        if (ret != null) {
            return ret;
        }

        ret = find(root.right,val);
        if (ret != null) {
            return ret;
        }
        return null;
    }

    // 判断一棵树是不是完全二叉树
    boolean isCompleteTree(Node root) {
        if(root == null) return true;
        Queue<Node> queue = new LinkedList<> ();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            }else {
                break;
            }
        }
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur != null) {
                return false;
            }
        }
        return true;
    }

    /**
     * 非递归
     * @param root
     */
    // 前序遍历
    void preOrderTraversal1(Node root) {
        if(root == null) return;
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                System.out.print(cur.val);
                cur = cur.left;
            }
            Node top = stack.pop();
            cur = top.right;
        }
    };
    // 中序遍历
    void inOrderTraversal1(Node root) {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            Node top = stack.pop();
            System.out.print(top.val);
            cur = top.right;
        }
        System.out.println();
    };

    // 后序遍历
    void postOrderTraversal1(Node root) {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            Node top = stack.peek();
            if (top.right == null) {
                stack.pop();
                System.out.print(top.val);
            }else {
                cur = top.right;
            }
        }
        System.out.println();
    };

}
