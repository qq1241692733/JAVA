package List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-01-2021/1/23
 * Time: 15:26
 */
class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }
}

class MyLinkedList {
    public Node head;
    /** Initialize your data structure here. */
    public MyLinkedList() {
    }

    public void display() {
        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
    public int size() {
        Node cur = this.head;
        int count = 0;
        while(cur != null) {
            count ++;
            cur = cur.next;
        }
        return count;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index >= size() || this.head == null) {
            return -1;
        }
        Node cur = this.head;

        while(index != 0) {
            index --;
            cur = cur.next;
        }
        return cur.data;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val);
        if(this.head == null) {
            this.head = new Node(val);
        }else {
            node.next = this.head;
            this.head = node;
        }
    }
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(this.head == null) {
            this.head = new Node(val);
        }else {
            Node cur = this.head;
            while(cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(val);
        }
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > size()) {
            return;
        }
        Node node = new Node(val);
        if(index <= 0) {
            node.next = this.head;
            this.head = node;
            return;
        }
        if(index == size()) {
            Node cur = this.head;
            while(cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
            return;
        }

        Node prev = this.head;
        int count = 0;
        while(count != index - 1) {
            prev = prev.next;
            count ++;
        }
        node.next = prev.next;
        prev.next = node;
    }
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index > size() || index < 0) {
            return;
        }
        if(index == 0) {
            this.head = this.head.next;
            return;
        }
        if(index == size()) {
            Node cur = this.head;
            while(cur.next.next != null) {
                cur = cur.next;
            }
            cur.next = null;
            return;
        }

        Node prev = this.head;
        int count = 0;
        while(count != index - 1) {
            prev = prev.next;
            count ++;
        }
        prev.next = prev.next.next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
