import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
        2. 两数相加
 * User: hong yaO
 * Date: 2021-11-2021/11/11
 * Time: 6:41
 */
public class TestDemo2 {
    public static void main(String[] args) {

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead = null;
        ListNode cur = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            int sum = n1 + n2 + carry;
            carry = sum / 10;
            if (newHead == null) {
                newHead = cur = new ListNode(sum % 10);
            } else {
                cur.next = new ListNode(sum % 10);
                cur = cur.next;
            }
            if (l1 != null) l1= l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) cur.next = new ListNode(carry);
        return newHead;
    }
}
