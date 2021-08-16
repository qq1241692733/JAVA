package sort_0815;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-08-2021/8/15
 * Time: 18:26
 */
public class Sort {
    /***
     * 1.插入排序
     */
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int curNum = array[i];
            int j = i - 1;
            while (j >= 0 && curNum < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = curNum;
        }
    }
    /**
     * 2.希尔排序
     */
    public static void shellSort(int[] array) {
        int[] gap = {5, 3, 1};
        for (int i = 0; i < gap.length; i++) {

        }
    }
    public static void insertSortGap(int[] array, int gap) {
        for (int i = gap; i < array.length; i++) {
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
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = tmp;
        }
    }
    /**
     * 4.堆排序
     */
    public static void heapSort(int[] array) {
        int end = array.length- 1;
        for (int i = (end - 1) / 2; i > 0; i--) {
            adjustDown1(array, i, end);
        }
        for (int i = 0; i < array.length; i++) {
            swap(array, 0 , end);
            end --;
            adjustDown1(array, 0 , end);
        }
    }
    // 递归
    public static void adjustDown(int[] array, int parent, int end) {
        int child = 2 * parent + 1;
        if (child > end) {
            return;
        }
        if (child + 1 <= end && array[child + 1] > array[child]) {
            child++;
        }
        if (array[child] > array[parent]) {
            swap(array, child, parent);
            parent = child;
        }else {
            return;
        }
        adjustDown(array, parent, end);
    }
    // 非递归
    public static void adjustDown1(int[] array, int parent, int end) {
        int child = 2 * parent + 1;
        while (child < end) {
            if (child + 1 <= end && array[child + 1] > array[child]) {
                child++;
            }
            if (array[child] > array[parent]) {
                swap(array, child, parent);
                parent = child;
                child = 2 * parent + 1;
            }else {
                break;
            }
        }
    }
    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    /**
     * 5.冒泡排序
     */
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }
    /**
     * 6.快速排序  递归
     */
    public static void quickSort(int[] array) {
        quick(array, 0, array.length - 1);
    }
    public static void quick(int[] array, int low, int high) {
        if (low >= high) return;
        int piv = pivot(array, low, high);
        quick(array, low, piv - 1);
        quick(array, piv + 1, high);
    }
    public static int pivot(int[] array, int start, int end) {
        int tmp = array[start];
        while (start < end) {
            while (start < end && array[end] >= tmp) {
                end --;
            }
            array[start] = array[end];
            while (start < end && array[start] <= tmp) {
                start ++;
            }
            array[end] = array[start];
        }
        array[end] = tmp;
        return end;
    }

    /**
     * 7.快排 非递归
     */
    public static void quickSort1(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int low = 0;
        int high = array.length - 1;
        stack.push(low);
        stack.push(high);
        while (!stack.empty()) {
            high = stack.pop();
            low = stack.pop();
            int piv = pivot(array, low, high);
            if (piv > low + 1) {
                stack.push(low);
                stack.push(piv - 1);
            }
            if (piv < high - 1) {
                stack.push(piv + 1);
                stack.push(high);
            }
        }
    }

    /**
     * 8.归并排序  递归
     */
    public static void mergeSort(int[] array) {
        mergeSortInter(array, 0, array.length - 1);
    }
    public static void mergeSortInter(int[] array, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSortInter(array, low, mid);
            mergeSortInter(array, mid + 1, high);
            merge(array, low, mid, high);
        }
    }
    private static void merge(int[] array, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int s1 = low;
        int s2 = mid + 1;
        int k = 0;
        while (s1 <= mid && s2 <= high) {
            if (array[s1] < array[s2]) {
                temp[k++] = array[s1++];
            }
            if (array[s2] < array[s1]) {
                temp[k++] = array[s2++];
            }
        }
        while (s1 <= mid) {
            temp[k++] = array[s1++];
        }
        while (s2 <= high) {
            temp[k++] = array[s2++];
        }
        for (int i = 0; i < temp.length; i++) {
            array[low + i] = temp[i];
        }
    }
    /**
     * 9.归并排序  非递归
     */
    public static void mergeSort1(int[] array) {
        for (int gap = 1; gap < array.length; gap *= 2) {
            int s1 = 0;
            int e1 = s1 + gap - 1;
            int s2 = e1 + 1;
            int e2 = s2 + gap - 1 < array.length ? s2 + gap - 1 : array.length - 1;
            int[] temp = new int[array.length];
            int k = 0;
            while (s2 < array.length) {
                while (s1 <= e1 && s2 <= e2) {
                    if (array[s1] < array[s2]) {
                        temp[k++] = array[s1++];
                    }
                    if (array[s2] < array[s1]) {
                        temp[k++] = array[s2++];
                    }
                }
                while (s1 <= e1) {
                    temp[k++] = array[s1++];
                }
                while (s2 <= e2) {
                    temp[k++] = array[s2++];
                }
                s1 = e2 + 1;
                e1 = s1 + gap - 1;
                s2 = e1 + 1;
                e2 = s2 + gap - 1 < array.length ? s2 + gap - 1 : array.length - 1;
            }
            while (s1 < array.length) {
                temp[k++] = array[s1++];
            }
            for (int i = 0; i < array.length; i++) {
                array[i] = temp[i];
            }
        }
    }

}
