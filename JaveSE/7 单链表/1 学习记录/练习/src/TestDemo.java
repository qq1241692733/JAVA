/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2020-12-2020/12/30
 * Time: 19:44
 */
public class TestDemo {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.createLinHead(1);
        myLinkedList.addEnd(2);
        myLinkedList.addEnd(3);
        myLinkedList.addEnd(4);
        myLinkedList.addEnd(4);
        myLinkedList.addEnd(3);
        myLinkedList.addEnd(2);
        myLinkedList.remove(1);
        myLinkedList.removeAllKey(3);
        myLinkedList.display();
    }

    public static void main1(String[] args) {
        MyLinkedList myLinkedList=new MyLinkedList();
        myLinkedList.createLinked();
        myLinkedList.display();
        int n=1;
        Node node=myLinkedList.fineN(n);
        System.out.println("第"+n+"个元素是"+node.val);
        n=myLinkedList.size();
        System.out.println(n);

        myLinkedList.addFirst(32);
        myLinkedList.display();
        System.out.println("=============");
        myLinkedList.addEnd(30);
        myLinkedList.display();
        System.out.println("=============");
        myLinkedList.addIdex(100,3);
        myLinkedList.display();
    }




}
