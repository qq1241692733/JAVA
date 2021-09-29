import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/28
 * Time: 21:17
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class TestDemo {
    public static void main(String[] args) {

    }
    public static ListNode detectCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (set.add(cur)) {
                cur = cur.next;
            }else {
                return cur;
            }
        }
        return null;
    }

    public static ListNode detectCycle2(ListNode head) {
        ListNode cur = head;
        while (cur != null) {

        }
        return null;
    }
}
