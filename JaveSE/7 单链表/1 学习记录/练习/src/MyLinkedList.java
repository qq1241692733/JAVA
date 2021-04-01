import org.omg.PortableServer.THREAD_POLICY_ID;

import java.awt.event.KeyEvent;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2020-12-2020/12/30
 * Time: 19:19
 */

class Node {
    int val;
    Node next;
    public Node(int val) {
        this.val=val;
    }
}

public class MyLinkedList {
    public Node head;

    public Node createLinked() {
       //this.head= new Node(10);
        Node node1 = new Node(12);
        Node node2 = new Node(15);
        Node node3 = new Node(51);
        this.head=node1;
        node1.next = node2;
        node2.next = node3;
        return node1;
    }

    public Node createLinHead(int val) {
        this.head=new Node(val);
        return this.head;
    }

    public void display() {
        Node cur = this.head;
        while (cur != null) {
            System.out.println(cur.val);
            cur=cur.next;
        }
    }

    public Node fineN(int n) {
        if(this.head==null) {
            System.out.println("单链表为空");
            return  null;
        }
        int count=1;
        Node cur=this.head;
        while (count != n) {
            cur.next=cur;
            count++;
        }
        return cur;
    }

    public int size() {
        Node cur = this.head;
        int count=0;
        while(cur != null) {
            count++;
            cur=cur.next;
        }
        return count;
    }

    public void addFirst(int data) {  //头插法
        Node cur = new Node(data);
        if(this.head == null) {
            this.head.val = data;
        } else {
            cur.next = head;
            this.head = cur;
        }
    }

    public void addEnd(int data) {    //尾插法
        Node node = new Node(data);
        Node cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next=node;
    }

    public void addIdex(int data,int i) {
        Node node = new Node(data);
        int count = 0;
        Node cur = this.head;
        while (count != i-1) {
            count++;
            cur = cur.next;
        }
        node.next = cur.next;
        cur.next = node;
    }

    public Node searchPrev(int key) {   //找前驱
        Node cur =this.head;
        while (cur.next != null) {
            if (cur.next.val == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }


    public void remove(int key) {   //删除1个
        if (this.head == null) {
            return;
        }
        if (this.head.val == key) {
            this.head = this.head.next;
        }
        Node cur = searchPrev(key);
        if (cur == null) {
            System.out.println("没有这个key的前驱");
            return;
        } else {
            cur.next=cur.next.next;
        }
    }

    public void removeAllKey(int key) {  //删除所有Key结点
        if (this.head == null) {
            return;
        }
        Node pre = this.head;
        Node cur = pre.next;
        while (cur != null)
        {
            if (cur.val == key) {
                pre.next = cur.next;
            }else {
                pre = cur;
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

    public void reverseList1() {
        Node pre = null;
        Node cur = this.head;
        Node curNest = cur.next;
        while (cur != null) {
            if (curNest == null) {

            }
            pre.next = cur;
            cur.next = curNest;
            curNest = curNest.next;
        }
    }


    public Node middleNode() {
        int len = size()/2;
        Node cur = this.head;
        int count = 0;

        return cur;
    }

    public Node midLenNode1() {
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //找到倒数第K歌元素
    public Node FindKthToTail(int k) {
        Node slow = this.head;
        Node fast = this.head;
        while (k-1 != 0) {
            if (fast.next != null) {
                fast = fast.next;
                k--;
            }
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public Node mergeTwoLists(Node headA, Node headB) {
        Node newHead = new Node(-1);
        Node tmp = newHead;
        while (headA != null && headB != null) {
            if (headA.val > headB.val) {
                tmp.next = headB;
                headB = headB.next;
            }else {
                tmp.next = headA;
                headA = headA.next;
            }
            tmp = tmp.next;
        }
        if (headA != null) {
            tmp.next = headA;
        }
        if (headB != null) {
            tmp.next = headB;
        }
        return newHead.next;
    }


    public boolean chkPalindrome() {
        Node slow = this.head;
        Node fast = this.head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node cur = slow.next;
        while (cur != null) {
            Node curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        Node cur1 = this.head;
        while (slow != cur1) {
           if (cur1.val != slow.val) {
                return false;
           }
           if (cur1.next == slow) {
               return true;
           }
           cur1 = cur1.next;
           slow = slow.next;
       }
        return true;
    }

}
