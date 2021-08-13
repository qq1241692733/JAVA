package sort_0813;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-08-2021/8/13
 * Time: 16:47
 */
public class Sort {
    /**
     * 1.插入排序
     */
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int insertNum = array[i];
            int j = i - 1;
            while (j >= 0 && insertNum < array[j]) {
                array[j + 1] = array[j];
                j --;
            }
            array[j + 1] = insertNum;
        }
    }

    /**
     * 2.希尔排序
     */
    public static void shellSort(int[] array) {
        int[] gap = {5,2,1};
        for (int i = 0; i < gap.length; i++) {
            insertSortGap(array,i);
        }
    }

    private static void insertSortGap(int[] array, int gap) {
        for (int i = 0; i < array.length; i += gap) {
            int curNum = array[i];

        }
    }
}
