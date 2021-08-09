import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-08-2021/8/8
 * Time: 21:07
 */
public class Sort {
    /**
     * 1.直接插入排序：
     *   时间复杂度：最好 O(n)   最坏 O(n^2)   平均 O(n^2)
     *   空间复杂度: O(1)
     *   稳定性：稳定
     *   优化：折半查找，先用折半查找到队对应位置，再搬移
     */
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int curNum = array[i];
            int j = i - 1;
            while (j >= 0 && curNum < array[j]) {
                array[j + 1] = array[j];
                j --;
            }
            array[j + 1] = curNum;
        }
    }

    /**
     * 2.希尔排序:
     *   时间复杂度： 最好：O（n）  平均：O（n^1.3）  最坏：O（n^2）
     *   空间复杂度： O（1）
     *   稳定性： 不稳定
     */
    public static void shellSort(int[] array) {
//        int[] gap = {5, 3, 1};   //增量数组
//        for (int i = 0; i < gap.length; i++) {
//            shell(array, gap[i]);
//        }
        int gap = array.length;
        while (gap > 1) {
            insertSortGap(array, gap);
            gap = (gap / 3) + 1;
        }
        insertSortGap(array, 1);
    }
    private static void insertSortGap(int[] array, int gap) {
        for (int i = gap; i < array.length; i++) {
            int curNum = array[i];
            int j = i - gap;
            for (; j >= 0 && array[j] > curNum; j -= gap) {
                array[j + gap] = array[j];
            }
            array[j + gap] = curNum;
        }
    }

    /**
     *3.选择排序：
     *   时间复杂度： O（n^2）
     *   空间复杂度： O（1）
     *   稳定性： 不稳定
     *   优化：双向选择排序，每次从无序区间找出最大和最小的元素放到最前和最后
     */
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    /**
     *堆排序：
     * 基本原理也是选择排序，只是不在使用遍历的方式查找无序区间的最大的数，而是通过堆来选择无序区间的最大的
     * 数。
     *   时间复杂度： O（logn）
     *   空间复杂度： O（1）
     *   稳定性： 不稳定
     *   注意： 排升序要建大堆；排降序要建小堆
     */
    public static void heapSort(int[] array) {
        int end = array.length - 1;
        // 创建大根堆
        for (int i = (end - 1) / 2; i >= 0; i--) {
            adjustDown(array, i ,end);
        }

        while (end > 0) {
            swap(array, 0, end);
            adjustDown(array, 0, end - 1);
            end --;
        }
    }
    public static void adjustDown(int[] array, int parent, int end) {
        int child = 2 * parent + 1;  // maxChild 最大孩子
        while (child <= end) {
            if (child + 1 <= end && array[child + 1] > array[child]) {
                child = child + 1;
            }
            if (array[child] > array[parent]) {
                swap(array, child, parent);  // 交换
                parent = child;
                child = 2 * parent + 1;
            }else {
                break;
            }
        }
    }
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     *冒泡排序：
     *   时间复杂度： O（n^2）
     *   空间复杂度： O（1）
     *      稳定性： 稳定
     */
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
//        int end = array.length - 1;
//        while (end > 0) {
//            for (int i = 0; i < end; i++) {
//                if (array[i] > array[i + 1]) {
//                    int temp = array[i];
//                    array[i] = array[i + 1];
//                    array[i + 1] = temp;
//                }
//            }
//            end --;
//        }
    }
    /**
     *快速排序：
     *   时间复杂度： 最好（均匀划分）：O（nlogn）  最坏(有序的情况)：O（n^2）
     *   空间复杂度： O（logn）
     *      稳定性： 不稳定
     */
    public static int pivot(int[] array, int start, int end) {
        int temp = array[start];
        while (start < end) {
            while (start < end && array[end] >= temp) {
                end --;
            }
            array[start] = array[end];

            while (start < end && array[start] <= temp) {
                start ++;
            }
            array[end] = array[start];
        }
        array[end] = temp;
        return end;
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
