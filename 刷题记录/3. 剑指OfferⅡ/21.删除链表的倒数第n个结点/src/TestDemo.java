import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/28
 * Time: 9:20
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

    /**
     * 特例子  [1], 1 返回 [null];  [1 -> 2], 1
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(0, head);
        ListNode cur = newHead, curNext = newHead;
        while (n != 0) {
            curNext = curNext.next;
            n --;
        }
        while (curNext.next != null) {
            cur = cur.next;
            curNext = curNext.next;
        }
        cur.next = cur.next.next;
        return newHead.next;
    }
}
