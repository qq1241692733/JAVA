package sort_0815;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-08-2021/8/15
 * Time: 18:26
 */
public class TestDemo {
    public static void main(String[] args) {
        int[] array = {8,4,6,3,9,1,2,5,7};
        System.out.println(Arrays.toString(array));
        //Sort.insertSort(array);
        //Sort.shellSort(array);
        //Sort.selectSort(array);
        //Sort.heapSort(array);
        //Sort.bubbleSort(array);
        //Sort.quickSort(array);
        //Sort.quickSort1(array);
        //Sort.mergeSort(array);
        Sort.mergeSort1(array);
        System.out.println(Arrays.toString(array));
    }
}
