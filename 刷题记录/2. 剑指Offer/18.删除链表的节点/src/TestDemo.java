import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-08-2021/8/31
 * Time: 17:25
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class TestDemo {
    public static void main(String[] args) {

    }
    public static ListNode deleteNode(ListNode head, int val) {
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        if (head.val == val) {
            head = head.next;
        }
        return head;
    }
}
