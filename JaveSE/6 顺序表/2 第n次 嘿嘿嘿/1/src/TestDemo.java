import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-01-2021/1/2
 * Time: 18:03
 */
public class TestDemo {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.addLast(1);
        myArrayList.addLast(2);
        myArrayList.add(1,2);
        myArrayList.display();
        myArrayList.remove(2);
        myArrayList.display();
        myArrayList.clear();
        myArrayList.display();

    }

}
