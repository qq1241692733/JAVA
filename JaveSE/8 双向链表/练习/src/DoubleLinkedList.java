import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-01-2021/1/7
 * Time: 19:33
 */
class ListNode {
    private int val;
    private ListNode prev;
    private ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getPrev() {
        return prev;
    }

    public void setPrev(ListNode prev) {
        this.prev = prev;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}

public class DoubleLinkedList {
    public ListNode head;//头
    public ListNode last;

    //头插法
    public void addFirst(int data) {
        ListNode listNode = new ListNode(data);
        if (head == null) {
            this.head = listNode;
            this.last = this.head;
        } else {
            listNode.setNext(this.head);
            this.head.setPrev(listNode);
            this.head = listNode;
        }
    }
    //尾插法
    public void addLast(int data) {
        ListNode listNode = new ListNode(data);
        if (last == null) {
            this.head = listNode;
            this.last = this.head;
        } else {
            this.last.setNext(listNode);
            listNode.setPrev(this.last);
            this.last = listNode;
        }
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data) {
        ListNode cur = this.head;
        int len = 0;
        while (cur != null) {
            cur = cur.getNext();
            len++;
        }
        if (index > len || index < 0) {
            System.out.println("插入位置不合法");
            return;
        }
        ListNode listNode = new ListNode(data);
        if (index == 0) {
            listNode.setNext(this.head);
            this.head.setPrev(listNode);
            this.head = listNode;
            return;
        }
        if (index == len) {
            addLast(data);
            return;
        }
        cur = head;
        while (index != 1) {
            cur = cur.getNext();
            index --;
        }
        listNode.setNext(cur.getNext());
        cur.setNext(listNode);
        listNode.setPrev(cur);
        listNode.getNext().setPrev(listNode);

    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        ListNode cur = this.head;
        while(cur.getNext() != null) {
            if (cur.getVal() == key) {
                return true;
            }
            cur = cur.getNext();
        }
        return false;
    }

    //找到key返回该结点
    public ListNode FindNode(int key) {
        ListNode cur = this.head;
        while(cur != null) {
            if (cur.getVal() == key) {
                return cur;
            }
            cur = cur.getNext();
        }
        return null;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        if (this.head == null) {
            return;
        }
        ListNode cur = FindNode(key);
        if (cur == null) {
            return;
        }
        if (cur == this.head) {
            this.head = this.head.getNext();
            this.head.setPrev(null);
            return;
        }
        if (cur == this.last) {
            this.last = this.last.getPrev();
            this.last.setNext(null);
            return;
        }
        cur.getNext().setPrev(cur.getPrev());
        cur.getPrev().setNext(cur.getNext());
    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.getVal() == key) {
                if (cur == this.head) {
                    this.head = this.head.getNext();
                    this.head.setPrev(null);
                }else if (cur == this.last) {
                    this.last = this.last.getPrev();
                    this.last.setPrev(null);
                }
                else {
                    cur.getPrev().setNext(cur.getNext());
                    cur.getNext().setPrev(cur.getPrev());
                }
            }
            cur = cur.getNext();
        }
    }

    //得到单链表的长度
    public int size() {
        int len = 0;
        ListNode cur = this.head;
        while (cur != null) {
            cur = cur.getNext();
            len++;
        }
        return len;
    }

    public void display() {
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.getVal() + " ");
            cur = cur.getNext();
        }
        System.out.println();
    }

    public void clear() {
    this.head = null;
    this.last = null;
    }

}
