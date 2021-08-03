import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-08-2021/8/3
 * Time: 20:16
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
public class TestDemo {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> retList = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                list.add(cur.val);
                queue.addAll(cur.children);
            }
            retList.add(list);
        }
        return retList;
    }
}
