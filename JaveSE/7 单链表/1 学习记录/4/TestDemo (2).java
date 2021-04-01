/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GaoBo
 * Date: 2020-12-30
 * Time: 19:16
 */
public class TestDemo {
    /*public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if(headA == null || headB == null) {
                return null;
            }
            int lenA = 0;
            int lenB = 0;
            ListNode pl = headA;//永远指向最长的链表
            ListNode ps = headB;//永远指向最短的链表
            while(pl != null) {
                pl = pl.next;
                lenA++;
            }
            while(ps != null) {
                ps = ps.next;
                lenB++;
            }
            pl = headA;
            ps = headB;//一定要指回来
            int len = lenA - lenB;
            if(len < 0) {
                pl = headB;
                ps = headA;
                len = lenB-lenA;
            }
            //我肯定是pl是最长的那个链表 ps是最短的那个链表
            while(len != 0) {
                pl = pl.next;
                len--;
            }

            while(pl != ps) {
                pl = pl.next;
                ps = ps.next;
            }
            //pl == ps
            return pl;
        }
    }
*/







    public  Node mergeTwoLists(Node headA, Node headB) {
        Node newHead = new Node(-1);
        Node tmp = newHead;
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

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(1);
        myLinkedList.addLast(12);
        myLinkedList.addLast(31);
        myLinkedList.addLast(41);
        myLinkedList.addLast(57);
        myLinkedList.display();

        MyLinkedList myLinkedList2 = new MyLinkedList();
        myLinkedList2.addLast(1);
        myLinkedList2.addLast(2);
        myLinkedList2.addLast(13);
        myLinkedList2.addLast(40);
        myLinkedList2.addLast(99);
        myLinkedList2.display();

        TestDemo testDemo = new TestDemo();
        Node ret = testDemo.mergeTwoLists
                (myLinkedList.head,myLinkedList2.head);

        myLinkedList2.display(ret);
    }

    public static void main5(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(1);
        myLinkedList.addLast(2);
        myLinkedList.addLast(3);
        myLinkedList.addLast(2);
        myLinkedList.addLast(1);
        myLinkedList.display();
       /* Node ret = myLinkedList.reverseList3();
        myLinkedList.display(ret);
*/
        Node ret = myLinkedList.findKthToTail(5);
        System.out.println(ret.val);
    }

    public static void main4(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(1);
        myLinkedList.addLast(2);
        myLinkedList.addLast(3);
        myLinkedList.addLast(4);
        myLinkedList.addLast(5);
        myLinkedList.display();
        myLinkedList.clear();
        System.out.println("=================");
    }

    public static void main3(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addFirst(19);
        myLinkedList.addFirst(29);
        myLinkedList.addFirst(39);
        myLinkedList.display();//39 29 19
        myLinkedList.addLast(1);
        myLinkedList.addLast(2);
        myLinkedList.addLast(3);
        myLinkedList.addLast(4);
        myLinkedList.display();//39 29 19 1 2 3 4
        myLinkedList.addIndex(0,110);
        myLinkedList.display();//110 39 29 19 1 2 3 4
        myLinkedList.addIndex(2,120);
        myLinkedList.display();//110 39 120 29 19 1 2 3 4
        myLinkedList.addIndex(9,119);
        myLinkedList.display();//110 39 120 29 19 1 2 3 4 119
        myLinkedList.addIndex(-9,119);
    }

    public static void main2(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        //这个函数结束之后，我们拿到了当前链表的头节点
        myLinkedList.createLinked();
        myLinkedList.display();
        System.out.println("==================");
        int n = 4;
        Node ret = myLinkedList.findN(n);
        System.out.println("第"+n+"个节点是："+ret.val);
        System.out.println("==================");
        System.out.println(myLinkedList.size());
        System.out.println("==================");
        System.out.println(myLinkedList.contains(421));
    }
    public static void main1(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        //这个函数结束之后，我们拿到了当前链表的头节点
        myLinkedList.createLinked();
        myLinkedList.display();
        System.out.println("==================");
        try {
            //放的是可能出现异常代码
            Node ret = myLinkedList.findLastTwoNode();
            System.out.println(ret.val);
        }catch (NullPointerException e) {

        }
        System.out.println("==================");
        /*ret = myLinkedList.findLastTwoNode();
        System.out.println(ret.val);*/
        System.out.println("虽然发生了异常，但是我还是想打印这句话");

    }
}
