import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-01-2021/1/31
 * Time: 12:20
 */
public class TestDemo {
    /**
     *直接插入排序:
     *  时间复杂度： 最好：O（n）  平均：O（n^2）  最坏：O（n^2）
     *  空间复杂度： O（1）
     *     稳定性： 稳定
     */
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];          
            int j = i;
            while (j > 0 && tmp < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = tmp;
        }
    }


    /**
     *希尔排序：
     *   时间复杂度： 最好：O（n）  平均：O（n^1.3）  最坏：O（n^2）
     *   空间复杂度： O（1）
     *      稳定性： 不稳定
     */
    public static void shell(int[] array ,int gap) {
        for (int i = gap; i < array.length; i++) {
            int tmp = array[i];
            int j = i;
            while (j > 0 && tmp < array[j - gap]) {
                array[j] = array[j - gap];
                j -= gap;
            }
            array[j] = tmp;
        }
    }

    public static void shellSort(int[] array) {
        int[] drr = {7,5,1};//增量数组

        for (int i = 0; i < drr.length; i++) {
            shell(array,drr[i]);
        }
    }

    /**
     *选择排序：
     *   时间复杂度： O（n^2）
     *   空间复杂度： O（1）
     *      稳定性： 不稳定
     */
    public static void selectSort(int[] array) {
//        for (int i = 0; i < array.length - 1; i++) {
//            for (int j = i + 1; j < array.length; j++) {
//                if (array[j] < array[i]) {
//                    int tmp = array[j];
//                    array[j] = array[i];
//                    array[i] = tmp;
//                }
//            }
//        }
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            int tmp = array[min];
            array[min] = array[i];
            array[i] = tmp;
        }
    }


    /**
     *堆排序：
     *   时间复杂度： O（logn）
     *   空间复杂度： O（1）
     *      稳定性： 不稳定
     */

    /**
     *冒泡排序：
     *   时间复杂度： O（n^2）
     *   空间复杂度： O（1）
     *      稳定性： 稳定
     */

    /**
     *快速排序：
     *   时间复杂度： 最好（均匀划分）：O（nlogn）  最坏(有序的情况)：O（n^2）
     *   空间复杂度： O（logn）
     *      稳定性： 不稳定
     */
    public static int pivot(int[] array, int start, int end) {
        int tmp = array[start];
        while (start < end) {
            while (array[end] >=  tmp && start < end) {
                end--;
            }
            //把数据赋值给start
            array[start] = array[end];
            while (array[start] <= tmp && start < end) {
                start++;
            }
            //把start下标的值给end
            array[end] = array[start];
        }
        array[start] = tmp;
        return start;
    }
    public static void quick(int[] array, int low, int high) {
        if (low < high) {
            int piv = pivot(array, low, high);
            quick(array, low, piv - 1);
            quick(array, piv + 1, high);
        }
    }
    public static void quickSort(int[] array) {
        quick(array, 0, array.length - 1);
    }

}
