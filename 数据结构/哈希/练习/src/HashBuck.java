/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-02-2021/2/5
 * Time: 11:52
 */
public class HashBuck {
    static class Node {
        public int key;
        public int val;
        public Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public Node[] array;
    public int usedSize;

    public HashBuck() {
        this.array = new Node[8];
    }

    public void push(int key, int val) {
        Node node = new Node(key, val);
        int index = key % array.length;
        Node cur = array[index];
        while (cur != null) {
            if (cur.key == key) {
                cur.val = val;
                return;
            }
            cur = cur.next;
        }
        node.next = array[index];
        array[index] = node;
        this.usedSize ++;
    }

    public double loadFactor() {
        return this.usedSize *1.0 / this.array.length;
    }

    public void resize() {
        Node[] newArray = new Node[2 * array.length];
        for (int i = 0; i < array.length; i++) {
            Node cur = array[i];
            while (cur != null) {
                int index = cur.key % newArray.length;
                Node curNext = cur.next;
                cur.next = newArray[index];
                newArray[index] = cur;
                cur = curNext;
            }
        }
        array = newArray;
    }

    public int get(int key) {
        int index = key % array.length;
        Node cur = array[index];
        while(cur != null) {
            if (cur.key == key) {
                return cur.val;
            }
            cur = cur.next;
        }
        return -1;
    }

}
