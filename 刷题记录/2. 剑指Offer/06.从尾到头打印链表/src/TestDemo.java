import jdk.internal.org.objectweb.asm.Handle;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.Stack;

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
        System.out.println(Arrays.toString(reversePrint(head)));
    }
    public static int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }
        return print;
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
