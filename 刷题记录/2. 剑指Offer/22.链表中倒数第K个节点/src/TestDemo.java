/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-08-2021/8/31
 * Time: 17:18
 */

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

public class TestDemo {
    public static void main(String[] args) {

    }
    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode pre = head;
        ListNode cur = head;
        while (k != 0) {
            if (cur == null) return null;
            cur = cur.next;
            k --;
        }
        while (cur != null) {
            cur = cur.next;
            pre = pre.next;
        }
        return pre;
    }
}
