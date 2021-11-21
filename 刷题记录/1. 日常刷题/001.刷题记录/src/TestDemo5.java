import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * N叉树的最大深度
 * User: hong yaO
 * Date: 2021-11-2021/11/21
 * Time: 22:25
 */
public class TestDemo5 {
    public static void main(String[] args) {

    }

    // DFS
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int ans = 0;
        List<Node> list = root.children;
        for (Node node : list) {
            ans = Math.max(ans, maxDepth(node));
        }
        return ans + 1;
    }

    // BFS
    public int maxDepth1(Node root) {
        if (root == null) return 0;
        int ans = 0;
        Deque<Node> d = new ArrayDeque<>();
        d.addLast(root);
        while (!d.isEmpty()) {
            int size = d.size();
            while (size-- > 0) {
                Node t = d.pollFirst();
                for (Node node : t.children) {
                    d.addLast(node);
                }
            }
            ans++;
        }
        return ans;
    }
}
