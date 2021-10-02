import java.util.Stack;

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

    /**
     * 链表的长度范围为 [1, 100]，不能用int 记录
     * 特殊例子 [0] [0]
     */
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
        System.out.println(num1);
        if (num1 == 0) cur = new ListNode(0);
        while (num1 != 0) {
            ListNode node = new ListNode(num1 % 10);
            num1 /= 10;
            node.next = cur;
            cur = node;
        }
        return cur;
    }

    // 不可取，超int数据范围
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode cur = l1;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (cur != null) {
            stack1.add(cur.val);
            cur = cur.next;
        }
        cur = l2;
        while (cur != null) {
            stack2.add(cur.val);
            cur = cur.next;
        }
        cur = null;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int num1 = stack1.isEmpty() ? 0 : stack1.pop();
            int num2 = stack2.isEmpty() ? 0 : stack2.pop();
            ListNode node = new ListNode((num1 + num2 + carry) % 10, cur);
            carry = (num1 + num2 + carry) / 10;
            cur = node;
        }
        if (carry != 0) cur = new ListNode(carry, cur);
        return cur;
    }
}
