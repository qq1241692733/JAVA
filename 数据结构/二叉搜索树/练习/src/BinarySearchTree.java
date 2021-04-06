import javafx.beans.value.ObservableNumberValue;
import sun.java2d.pipe.SpanClipRenderer;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-02-2021/2/4
 * Time: 18:13
 */
public class BinarySearchTree {
    static class BSNode {
        public int val;
        public BSNode left;
        public BSNode right;
        public BSNode(int val) {
            this.val = val;
        }
    }
    public BSNode root = null;

    public BSNode search(int val) {
        if (root == null) return null;
        BSNode cur = root;
        while (cur != null) {
            if (cur.val == val) {
                return cur;
            }else if (cur.val < val) {
                cur = cur.right;
            }else {
                cur = cur.left;
            }
        }
        return null;
    }

    public boolean insert(int val) {
        BSNode bsNode = new BSNode(val);
        if (root == null) {
            root = bsNode;
            return true;
        }
        BSNode cur = root;
        BSNode parent = null;

        while (cur != null) {
            if (cur.val == val) {
                return false;
            }else if(cur.val < val) {
                parent = cur;
                cur = cur.right;
            }else {
                parent = cur;
                cur = cur.right;
            }
        }
        if (parent.val < val) {
            parent.right = bsNode;
        }else {
            parent.left = bsNode;
        }
        return true;
    }

    public void remove(int val) {
        if (root == null) return;
        BSNode cur = root;
        BSNode parent = null;
        while (cur != null) {
            if (cur.val < val) {
                parent = cur;
                cur = cur.right;
                parent = cur;
            }else if (cur.val > val) {
                cur = cur.left;
            }else {
                removeNode(val, cur, parent);
            }
        }
    }

    public void removeNode(int val, BSNode cur, BSNode parent) {
        if (cur.left == null) {
            if (cur == root) {
                root = cur.right;
            }else if (parent.right == cur) {
                parent.right = cur.right;
            }else  { //parent.left == cur
                parent.left = cur.right;
            }
        }else if (cur.right == null) {
            if (cur == root) {
                root = cur.left;
            }else if (parent.left == cur) {
                parent.left = cur.left;
            }else {
                parent.right = cur.left;
            }
        }else {
            BSNode targetParent = cur;
            BSNode target = cur.right;
            while (target != null) {
                targetParent = target;
                target = target.left;
            }
            cur.val = target.val;
            if (target == targetParent.left) {
                targetParent.left = target.right;
            }else {
                targetParent.right = target.right;
            }
        }
    }

}

