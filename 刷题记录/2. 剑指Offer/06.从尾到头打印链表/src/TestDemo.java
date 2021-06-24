
import java.util.Arrays;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
     输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
         输入：head = [1,3,2]
         输出：[2,3,1]
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
        Stack <ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        int [] reverseArr = new int[stack.size()];
        for (int i = 0; i < reverseArr.length; i++) {
            reverseArr[i] = stack.pop().val;
        }
        return reverseArr;
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
