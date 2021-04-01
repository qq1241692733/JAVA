package List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-01-2021/1/23
 * Time: 15:26
 */
public class TestDemo {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(4);
        System.out.println(linkedList.get(1));
        linkedList.addAtHead(1);
        linkedList.addAtHead(5);
        linkedList.display();
        linkedList.deleteAtIndex(3);
        linkedList.display();
        linkedList.addAtHead(7);
        linkedList.display();
        System.out.println(linkedList.get(3));
        System.out.println(linkedList.get(3));
        System.out.println(linkedList.get(3));
        linkedList.addAtHead(1);
        linkedList.display();
        linkedList.deleteAtIndex(4);
        linkedList.display();
    }
}
