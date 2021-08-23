import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-08-2021/8/22
 * Time: 22:22
 */
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class TestDemo {
    Map<Node, Node> map = new HashMap<>();
    public static void main(String[] args) {

    }

    /**
     * 方法1：回溯(递归) + 哈希表
     *  时间复杂度: O(n)
     *  空间复杂度：O(n)
     */
    public Node copyRandomList1(Node head) {
        if (head == null) return null;
        if (!map.containsKey(head)) {
            Node node = new Node(head.val);
            map.put(head, node);
            node.next = copyRandomList1(head.next);
            node.random = copyRandomList1(head.random);
        }
        return map.get(head);
    }

    /**
     * 方法2：迭代 + 节点拆分
     *  时间复杂度: O(1)
     *  空间复杂度：O(1)
     */
    public Node copyRandomList2(Node head) {
        if (head == null) return null;
        Node node = head;
        while (node != null) {
            Node newNode = new Node(node.val);
            newNode.next = node.next;
            node.next = newNode;
            node = node.next.next;
        }
        node = head;
        while (node != null) {
            Node newNode = node.next;
            if (node.random != null) {
                newNode.random = node.random.next;
            }else {
                newNode.random = null;
            }
            node = node.next.next;
        }
        node = head;
        Node newHead = head.next;
        while (node != null) {
            Node newNode = node.next;
            node.next = node.next.next;
            newNode.next = (newNode.next != null) ? newNode.next.next : null;
            node = node.next;
        }
        return newHead;
    }
}
