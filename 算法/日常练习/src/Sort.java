import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-08-2021/8/11
 * Time: 11:02
 */
public class Sort {
    /**
     * 1. 直接插入排序
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
     * 2.希尔排序
     */
    public static void shellSort(int[] array) {
        int[] gap = {5, 3, 1};
        for (int gapNum : gap) {
            insertSortGap(array, gapNum);
        }
    }
    public static void insertSortGap(int[] array, int gap) {
        for (int i = gap; i < array.length; i ++) {
            int curNum = array[i];
            int j = i - gap;
            while (j >= 0 && curNum < array[j]) {
                array[j + gap] = array[j];
                j -= gap;
            }
            array[j + gap] = curNum;
        }
    }

    /**
     * 3.选择排序
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
     * 4.堆排序
     */
    public static void heapSort(int[] array) {
        int end = array.length - 1;
        for (int i = (end - 2) / 2; i >= 0 ; i--) {
            adjustDown(array, i, end);
        }
        while (end > 0) {
            swap(array, 0, end);
            adjustDown(array, 0, -- end);
        }
    }
    public static void adjustDown(int[] array, int parent, int end) {
        int child = 2 * parent + 1;
        while (child < end) {
            if (child + 1 <= end && array[child + 1] > array[child]) {
                child++;
            }
            if (array[child] > array[parent]) {
                swap(array, parent, child);
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
     * 5.冒泡排序
     */
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    /**
     * 6.快速排序
     */
    public static void quickSort(int[] array) {
        quick(array, 0, array.length - 1);
    }
    public static void quick(int[] array, int low, int high) {
        if (low < high) {
            int piv = pivot(array, low, high);
            quick(array, low, piv - 1);
            quick(array, piv + 1, piv);
        }
    }
    private static int pivot(int[] array, int start, int end) {
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

    /**
     * 7.快排非递归
     *     使用 栈 或 队列
     */
    public static void quickSort1(int[] array) {
        Queue<Integer> queue = new LinkedList<>();
        int low = 0;
        int high = array.length - 1;
        int piv = pivot(array, low, high);
        if (piv > low + 1) {
            queue.add(low);
            queue.add(piv - 1);
        }
        if (piv < high - 1) {
            queue.add(piv + 1);
            queue.add(high);
        }
        while (!queue.isEmpty()) {
            low = queue.poll();
            high = queue.poll();
            piv = pivot(array, low, high);
            if (piv > low + 1) {
                queue.add(low);
                queue.add(piv - 1);
            }
            if (piv < high - 1) {
                queue.add(piv + 1);
                queue.add(high);
            }
        }
    }

    /**
     * 8.归并排序
     */
    public static void mergeSort(int[] array) {
        mergeSortInternal(array, 0, array.length - 1);
    }
    public static void mergeSortInternal(int[] array, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSortInternal(array, low, mid);
            mergeSortInternal(array, mid + 1, high);
            merge(array, low, mid, high);
        }
    }
    public static void merge(int[] array, int low, int mid, int high) {
        int s1 = low;
        int s2 = mid + 1;
        int[] tmp = new int[high - low + 1];
        int tmpIndex = 0;
        while (s1 <= mid && s2 <= high) {
            if (array[s1] <= array[s2]) {
                tmp[tmpIndex++] = array[s1++];
            }
            if (array[s2] <= array[s1]) {
                tmp[tmpIndex++] = array[s2++];
            }
        }
        while (s1 <= mid) {
            tmp[tmpIndex++] = array[s1++];
        }
        while (s2 <= high) {
            tmp[tmpIndex++] = array[s2++];
        }
        for (int i = 0; i < tmp.length; i++) {
            array[i + low] = tmp[i];
        }
    }
    /**
     * 9.归并非递归
     */
    public static void mergeSort1(int[] array) {
        for (int gap = 1; gap < array.length; gap *= 2) {
            int s1 = 0;
            int e1 = s1 + gap - 1;
            int s2 = e1 + 1;
            int e2 = s2 + gap - 1 < array.length ? s2 + gap - 1 : array.length - 1;
            int[] tmp = new int[array.length];
            int tmpIndex = 0;

            while (s2 < array.length) {
                while (s1 <= e1 && s2 <= e2) {
                    if (array[s1] <= array[s2]) {
                        tmp[tmpIndex++] = array[s1++];
                    }
                    if (array[s2] <= array[s1]) {
                        tmp[tmpIndex++] = array[s2++];
                    }
                }
                while (s1 <= e1) {
                    tmp[tmpIndex++] = array[s1++];
                }
                while (s2 <= e2) {
                    tmp[tmpIndex++] = array[s2++];
                }
                s1 = e2 + 1;
                e1 = s1 + gap - 1;
                s2 = e1 + 1;
                e2 = s2 + gap - 1 < array.length ? s2 + gap - 1 : array.length - 1;
            }
            while (s1 < array.length) {
                tmp[tmpIndex++] = array[s1++];
            }
            for (int i = 0; i < tmp.length; i++) {
                array[i] = tmp[i];
            }

        }
    }
}
