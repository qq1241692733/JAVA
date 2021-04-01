/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-01-2021/1/1
 * Time: 21:19
 */
public class TestDemo {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList(10);
        myArrayList.add(0,1);
        myArrayList.add2(2);
        myArrayList.add2(3);
        myArrayList.add2(4);
        myArrayList.add2(5);
        myArrayList.add2(6);
        if (myArrayList.contains(2)) {
            System.out.println("有");
        }
        myArrayList.display();
        myArrayList.remove(2);
        myArrayList.display();
        myArrayList.remove(100);
        myArrayList.display();
    }

}
