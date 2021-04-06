import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-01-2021/1/21
 * Time: 11:32
 */
public class TestDemo1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        //Arraylist底层时个数组
        list.add(1);
        list.add(0,2);
        System.out.println(list);
        List<Integer> list1 = new ArrayList<>();
        list1.addAll(list);
        System.out.println(list1);

        /**
         * 迭代器  打印集合中所有元素
         */
        list.add(3);
        list.add(4);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        iterator.remove();
    }
}
