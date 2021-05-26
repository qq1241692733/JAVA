import jdk.internal.org.objectweb.asm.Handle;

import java.util.ListIterator;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-05-2021/5/26
 * Time: 17:29
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
        reverseList(head);
        display(head);
//        int[] arr = reversePrint(head);
//        System.out.println(arr.toString());
    }

    public static int[] reversePrint(ListNode head) {
        int[] ret = new int[10];
        return ret;
    }

    // 反转链表
    public static void reverseList(ListNode head) {
        ListNode pre = head;
        ListNode cur = pre.next;
        ListNode curNext = cur;
        while (cur.next != null) {
            curNext = cur.next;

            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
        head = cur;
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
