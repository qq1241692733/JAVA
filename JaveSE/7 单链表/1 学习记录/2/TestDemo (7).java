/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GaoBo
 * Date: 2020-12-30
 * Time: 19:16
 */
public class TestDemo {

    public static void main(String[] args) {
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
