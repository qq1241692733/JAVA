/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-01-2021/1/4
 * Time: 9:52
 */

class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }
}

public class MyLinkedList {
    public Node head;
    public void creatLinked() {
        this.head = new Node(1);
    }

    public void display() {
        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public Node findLastNode() {
        if (this.head == null) {
            System.out.println("head = null");
            return null;
        }
        Node cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }

    public Node findN(int n) {
        if (this.head == null) {
            System.out.println("head = null");
            return null;
        }
        if (n <= 0 || n > size()){
            System.out.println("查找的位置不合法");
            return null;
        }
        Node cur = this.head;
        int count = 1;
        while (count != n) {
            count++;
            cur = cur.next;
        }
        return cur;
    }

    //得到单链表的长度
    public int size() {
        Node cur = this.head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    //查找是否包含关键字key是否在单链表中
    public boolean contains(int key) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //头插法
    public void addFirst(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
        }else {
            node.next = this.head;
            this.head = node;
        }

    }

    //尾插法
    public void addLast(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
        }else {
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    //任意位置插入，第一个数据结点下标为0
    public void addIndex(int index, int data) {
        if(index < 0 || index > size()) {
            System.out.println("index不合法");
            return;
        }
        Node node = new Node(data);
        if (index == 0) {        //头插
            node.next = this.head;
            this.head = node;
            return;
        }
        if (index == size()) {   //尾插
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
            return;
        }

        Node prev = head;
        int count = 0;
        while (count != index-1) {    //知道下标index找index前驱prev
            count++;
            prev = prev.next;
        }
        node.next = prev.next;
        prev.next = node;
    }

    //找到关键key的前驱，如果有返回前驱节点的引用
    public Node searchPrev(int key) {
        Node cur = this.head;
        while (cur.next != null) {
            if (key == cur.next.data) {
                return cur;
            }
        }
        return null;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        if (this.head == null) {
            return;
        }
        if (this.head.data == key) {
            this.head = this.head.next;
            return;
        }
        Node prev = searchPrev(key);
        if (prev == null) {
            System.out.println("没有要删除的关键字");
        }else {
            prev.next = prev.next.next;
        }
    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {
        if (this.head == null) {
            return;
        }
        Node prev = this.head;
        Node cur = prev.next;
        while (prev.next != null) {
            if (cur.data == key) {
                prev.next = cur.next;
            }else {
                prev = cur;
            }
            cur = cur.next;
        }
        if (this.head.data == key) {
            this.head = this.head.next;
        }
    }

    //清除链表
    public void clear() {
        this.head = null;
    }

}
