package demo0106;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2022-01-2022/1/6
 * Time: 17:07
 */
public class Sort {
    public static void heapSort(int[] array) {
        int end = array.length - 1;
        for (int i = (end - 1) / 2; i >= 0 ; i--) {
            adjustDown(array, i, end);
        }
        while (end > 0) {
            swap(array, 0, end);
            end --;
        }
    }

    private static void adjustDown(int[] array, int parent, int end) {
        int child = parent + 1;
        while (child <= end) {
            // 找出最大子结点
            if (child + 1 <= end && array[child + 1] > array[child]) {
                child += 1;
            }
            // 最大子结点是否大于父亲结点
            if (array[child] > array[parent]) {
                // 交换
                swap(array, child, parent);
                // 继续下一轮调整
                parent = child;
                child = 2 * parent + 1;
            } else {
                break;
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
