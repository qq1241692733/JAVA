/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/29
 * Time: 20:13
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur = l1;
        int num1 = 0;
        int num2 = 0;
        while (cur != null) {
            num1 = num1 + cur.val * 10 ;
            cur = cur.next;
        }
        cur = l2;
        while (cur != null) {
            num2 = num2 + cur.val * 10 ;
            cur = cur.next;
        }
        cur = null;
        num1 = num1 + num2;
        while (num1 != 0) {
            ListNode node = new ListNode(num1 % 10);
            num1 /= 10;
            node.next = cur;
            cur = node;
        }
        return cur;
    }
}
