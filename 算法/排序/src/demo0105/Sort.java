package demo0105;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2022-01-2022/1/5
 * Time: 17:29
 */
public class Sort {

    // 1.直接插入排序
    public static void insertSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int curNum = array[i];
            int j = i - 1;
            while (j >= 0 && curNum < array[j]) {
                array[j + 1] = array[j];
                j --;
            }
            array[j + 1] = curNum;
        }
    }

    // 2.希尔排序
    public static void shellSort(int array[]) {
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
            while (j >= 0 && curNum < array[j]) {
                array[j + gap] = array[j];
                j -= gap;
            }
            array[j + gap] = curNum;
        }
    }

    // 3.选择排序： 挑出最小的
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

    // 4.堆排序



}
