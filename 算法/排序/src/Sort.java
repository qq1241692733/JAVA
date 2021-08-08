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
     */
    public static void selectSort(int[] array) {

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

}
