import com.sun.org.apache.bcel.internal.generic.LUSHR;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/3
 * Time: 23:27
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
    public boolean isPalindrome1(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            nums.add(cur.val);
            cur = cur.next;
        }
        int len = nums.size();
        int left = 0;
        int right = len - 1;
        while (left < right) {
            if (nums.get(left) != nums.get(right)) {
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }
}
