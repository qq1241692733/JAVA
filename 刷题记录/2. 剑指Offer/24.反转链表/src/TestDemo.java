/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-05-2021/5/26
 * Time: 18:36
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
public class TestDemo {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = new ListNode(2);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(4);
        head.next = node;
        node.next = node1;
        node1.next = node2;
        display(head);
        ListNode newHead = reverseList(head);
        display(newHead);
//        int[] arr = reversePrint(head);
//        System.out.println(arr.toString());
    }

    public static int[] reversePrint(ListNode head) {
        int[] ret = new int[10];
        return ret;
    }

    // 反转链表
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode curNext = cur;
        while (cur != null) {
            curNext = cur.next;

            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
        return pre;
    }

    public static void display(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
