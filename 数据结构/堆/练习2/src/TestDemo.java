import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-01-2021/1/31
 * Time: 14:40
 */
public class TestDemo {
    public static void main(String[] args) {
        HeapDemo heapDemo = new HeapDemo();
        int[] array = {27,15,19,18,28,34,69,49,25,37};
        System.out.println(Arrays.toString(array));
        heapDemo.createBigHeap(array);
        heapDemo.show();
        System.out.println(heapDemo.poll());
        heapDemo.show();
    }
}
