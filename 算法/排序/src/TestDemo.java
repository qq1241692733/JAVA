import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-08-2021/8/8
 * Time: 20:51
 */
public class TestDemo {
    public static void main(String[] args) {
        int[] array = {8,6,4,2,9,5,7,1,3,10};
        System.out.println(Arrays.toString(array));
        //Sort.insertSort(array);
        //Sort.shellSort(array);
        //Sort.selectSort(array);
        //Sort.heapSort(array);
        //Sort.bubbleSort(array);
        //Sort.quickSort(array);
        //Sort.quickSort1(array);
        //Sort.quickSort2(array);
        //Sort.mergeSort(array);
        Sort.mergeSort1(array);
        System.out.println(Arrays.toString(array));
    }
}
