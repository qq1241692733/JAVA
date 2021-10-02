import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/2
 * Time: 17:01
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
    public void reorderList(ListNode head) {
        if (head == null) return;
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            list.get(left).next = list.get(right);
            left ++;
            if (left == right) break;
            list.get(right).next = list.get(left);
            right --;
        }
        list.get(left).next = null;
    }

    /**
     *   反转链表， 合并链表
     */
    public void reorderList2(ListNode head) {
        if (head == null) return;
        ListNode l1 = head;
        ListNode mid = midNode(head);
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    private void mergeList(ListNode l1, ListNode l2) {
        ListNode next1 = l1;
        ListNode next2 = l2;
        while (l1 != null && l2 != null) {
            next1 = l1.next;
            next2 = l2.next;
            l1.next = l2;
            l1 = next1;
            l2.next = l1;
            l2 = next2;
        }
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode curNext = head;
        while (cur != null) {
            curNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return prev;
    }

    private ListNode midNode(ListNode head) {
        ListNode slow =head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
