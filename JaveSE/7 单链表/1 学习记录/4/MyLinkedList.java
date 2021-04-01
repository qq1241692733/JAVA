/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GaoBo
 * Date: 2020-12-30
 * Time: 19:17
 */
class Node {
    public int val;
    public Node next;
    public Node() {

    }
    public Node(int val) {
        this.val = val;
    }
}

public class MyLinkedList {

    public Node head;//表示当前链表的头 默认是null

    /**
     *
     */
    public void createLinked() {
        this.head = new Node(12);
        Node node2 = new Node(22);
        Node node3 = new Node(32);
        Node node4 = new Node(42);
        this.head.next = node2;
        node2.next = node3;
        node3.next = node4;
    }

    public void display() {
        Node cur = this.head;
        while (cur != null) {
            System.out.print (cur.val +" ");
            //
            cur = cur.next;
        }
        System.out.println();
    }

    /**
     * 从指定的位置newHead
     * 开始进行打印
     * @param newHead
     */
    public void display(Node newHead) {
        Node cur = newHead;
        while (cur != null) {
            System.out.print (cur.val +" ");
            cur = cur.next;
        }
        System.out.println();
    }


    public Node findLastNode() {
        if(this.head == null) {
            System.out.println("head == null");
            return null;
        }
        Node cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 这个代码有瑕疵  改这个代码
     * @return
     */
    public Node findLastTwoNode() {
        if(this.head == null) {
            System.out.println("想啥呢，什么都没有！");
            return null;
        }
        if(this.head.next == null) {
            System.out.println("想啥呢，只有1个节点！");
            return null;
        }
        Node cur = this.head;
        while (cur.next.next != null) {
            cur = cur.next;
        }
        return cur;
    }

    public Node findN(int n) {
        if(this.head == null) {
            System.out.println("单链表为空！");
            return null;
        }
        if(n <= 0) {
            System.out.println("n太小了！");
            return null;
        }
        if(n > size()) {
            System.out.println("n太大了");
            return null;
        }
        int count = 1;
        Node cur = this.head;
        while (count != n) {
            count++;//1
            cur = cur.next;
        }
        return cur;
    }

    //得到单链表的长度
    public int size(){
        Node cur = this.head;
        int count = 0;
        while (cur != null) {
            count++;//2
            cur = cur.next;
        }
        return count;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        Node cur = this.head;
        while (cur != null) {
            if(cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //头插法
    public void addFirst(int data) {
        //0、首先你得有个节点
        Node node = new Node(data);
        //1、判断链表是不是空的
        if(this.head == null) {
            this.head = node;
        }else {
            //2、插入
            node.next = this.head;
            this.head = node;
        }
        //0、首先你得有个节点
       /* Node node = new Node(data);
        //1、判断链表是不是空的
        node.next = this.head;
        this.head = node;*/
    }




    //尾插法
    public void addLast(int data) {
        //0、new
        Node node = new Node(data);
        if(this.head == null) {
            this.head = node;
        }else {
            //1、cur 找尾巴
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            //2、插入
            cur.next = node;
        }
    }

    /**
     * 该函数是找到index-1位置的节点的引用
     * @param index
     * @return
     */
    public Node moveIndex(int index) {
        Node cur = this.head;
        int count = 0;
        while (count != index-1) {
            cur = cur.next;
            count++;
        }
        return cur;
    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data) {
        if(index < 0 || index > size()) {
            System.out.println("index不合法");
            return;
        }
        //头插法
        if(index == 0) {
            addFirst(data);
            return;
        }
        //尾插法
        if(index == size()) {
            addLast(data);
            return;
        }
        Node cur = moveIndex(index);
        //cur保存的是 index-1位置的节点的引用
        Node node = new Node(data);
        node.next = cur.next;
        cur.next = node;
    }

    /**
     * 找到关键key的前驱，如果有返回前驱节点的引用
     * 如果没有返回null
     * @param key
     * @return
     */
    public Node searchPrev(int key) {
        Node cur = this.head;

        while (cur.next != null) {
            if(cur.next.val == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        if(this.head == null) {
            return;
        }
        if(this.head.val == key) {
            this.head = this.head.next;
            return;
        }
        Node prev = searchPrev(key);
        if(prev == null) {
            System.out.println("没有这个key的前驱");
        }else {
            Node del = prev.next;
            prev.next = del.next;
        }
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        Node prev = this.head;
        Node cur = prev.next;
        while (cur != null) {
            if(cur.val == key) {
                prev.next = cur.next;
            }else {
                prev = cur;
            }
            cur = cur.next;
        }
        if(this.head.val == key) {
            this.head = this.head.next;
        }
    }


    public void clear() {
        this.head = null;
    }


    public Node reverseList() {
        Node cur = this.head;
        Node prev = null;
        Node newHead = null;
        while (cur != null) {
            Node curNext = cur.next;
            if(curNext == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }

    public Node reverseList2() {
        Node prev = null;
        while (head != null) {
            Node cur = this.head;
            this.head = head.next;
            cur.next = prev;
            prev = cur;
        }
        return prev;
    }
    public Node reverseList3() {
       Node cur = this.head;
       Node prev = null;
       while (cur != null) {
           Node curNext = cur.next;
           cur.next = prev;
           prev = cur;
           cur = curNext;
       }
       return prev;
    }

    public Node middleNode1() {
        int len = size()/2;
        Node cur = this.head;
        int count = 0;
        while (count != len) {
            cur = cur.next;
            count++;
        }
        return cur;
    }

    public Node middleNode() {
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public Node findKthToTail(int k) {
        //不写是可以的
        if(this.head == null || k <= 0) {
            return null;
        }

        Node fast = head;
        Node slow = head;
        while(k-1 != 0) {
            //每次走之前 判断当前fast是不是已经到尾巴节点了
            if(fast.next != null) {
                fast = fast.next;
                k--;
            }else{
                return null;//代表k的值过大
            }
        }

        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }



    /*class Solution {
        public ListNode mergeTwoLists(ListNode headA, ListNode headB) {
            ListNode newHead = new ListNode(-1);
            ListNode tmp = newHead;
            while(headA != null && headB != null) {
                if(headA.val > headB.val) {
                    tmp.next = headB;
                    headB = headB.next;
                }else{
                    tmp.next = headA;
                    headA = headA.next;
                }
                tmp = tmp.next;
            }
            //代码走到这里肯定是一个为空 一个不为空
            if(headA != null) {
                tmp.next = headA;
            }
            if(headB != null) {
                tmp.next = headB;
            }
            return newHead.next;
        }
    }*/

    /*public class Partition {
        public ListNode partition(ListNode pHead, int x) {
            // write code here
            if(pHead==null) return null;
            ListNode bs = null;
            ListNode be = null;
            ListNode as = null;
            ListNode ae = null;
            ListNode cur = pHead;
            while(cur != null) {
                if(cur.val < x) {
                    if(bs == null) {
                        //说明一个节点还没有的情况下
                        bs = cur;
                        be = cur;
                    }else {
                        //说明已经有了节点
                        be.next = cur;
                        be = be.next;
                    }
                }else{
                    if(as == null) {
                        //第2个段 第一次插入
                        as = cur;
                        ae = cur;
                    }else{
                        ae.next = cur;
                        ae = ae.next;
                    }
                }
                cur = cur.next;
            }
            if(bs == null) {
                //说明第一个段里面没有数据
                return as;
            }
            be.next = as;

            if(as != null) {
                //说明最后一段肯定有数据
                ae.next = null;
            }
            return bs;
        }
    }
*/

    public boolean chkPalindrome() {
        if(this.head == null) return false;
        // write code here
        //1、找到当前链表的中间位置
        Node fast = this.head;
        Node slow = this.head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //2、从中间位置开始，后半部分进行翻转
        Node cur = slow.next;
        while (cur != null) {
            Node curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        //3、head从头往后走   slow从后往前走
        //只要发现 对应的val值不一样 就返回false  直到head和slow相遇
        while(head != slow) {
            if(head.val != slow.val) {
                return false;
            }
            //偶数的情况
            if(head.next == slow) {
                return true;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    public boolean hasCycle(Node head) {
        if(head == null) return false;
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                break;
            }
        }
        //有2种情况 1、循环不满足   1种遇到break;
        if(fast == null || fast.next == null) {
            return false;
        }
        return true;

    }
    public Node detectCycle() {
        if(head == null) return null;
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                break;
            }
        }
        //有2种情况 1、循环不满足   1种遇到break;
        if(fast == null || fast.next == null) {
            return null;
        }
        //fast  slow
        slow = this.head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

}
