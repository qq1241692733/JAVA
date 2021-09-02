import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/1
 * Time: 16:36
 */
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
     }
 }

public class TestDemo {
    public static void main(String[] args) {

    }
    // 哈希表
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode temp = headA;
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (visited.contains(temp)) {
                System.out.println(temp);
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB) {
            nodeA = nodeA.next;
            nodeB = nodeB.next;
            if (nodeA == null && nodeB == null) return null;
            if (nodeA == null) nodeA = headB;
            if (nodeB == null) nodeB = headA;
        }
        return nodeA;
    }
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB) {
            if (nodeA == null) {
                nodeA = headB;
            }else {
                nodeA = nodeA.next;
            }
            if (nodeB == null) {
                nodeB = headA;
            }else {
                nodeB = nodeB.next;
            }
        }
        return nodeA;
    }

}
