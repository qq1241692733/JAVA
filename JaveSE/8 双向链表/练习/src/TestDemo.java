/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-01-2021/1/7
 * Time: 19:58
 */
public class TestDemo {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addLast(1);
        doubleLinkedList.addLast(2);
        doubleLinkedList.addLast(1);
        doubleLinkedList.addLast(2);
        doubleLinkedList.addIndex(2,3);
        doubleLinkedList.display();
        doubleLinkedList.remove(2);
        doubleLinkedList.display();
        doubleLinkedList.removeAllKey(1);
        doubleLinkedList.display();
    }
}
