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
    // 1.直接插入
    public static void insertSort(int[] array) {
        // 1.一张张揭牌，手中的牌一直是有序的
        for (int i = 1; i < array.length; i++) {
            // 揭到第 i 张牌
            int curNum = array[i];
            // 2.向前寻找可插入的地方
            int j = i - 1;
            while (j >= 0 && curNum < array[j]) {
                // 还没有到插入的位置，第j位置向后移动，留出空位
                array[j + 1] = array[j];
                j --;
            }
            // 3.插入揭到的牌
            array[j + 1] = curNum;
        }
    }

    // 2.希尔排序
    public static void shellSort(int[] array) {
        int gap = array.length;
        while (gap > 0) {
            insertSortGap(array, gap);
            // 缩小增量公式
            gap = gap /3 + 1;
        }
        // 此时数组已经区域有序， gap = 1 时，相当于直接插入排序
        insertSortGap(array,1);
    }

    private static void insertSortGap(int[] array, int gap) {
        // 对 array 中相隔 gap 的数字进行排序，累不直接插入排序
        for (int i = gap; i < array.length; i += gap) {
            int curNum = array[i];
            int j = i - gap;
            while (j >= 0 && curNum < array[j]) {
                array[j + gap] = array[j];
                j -= gap;
            }
            array[j + gap] = curNum;
        }
    }


    public static void heapSort(int[] array) {
        int end = array.length - 1;
        // 从最后一个非子叶节点开始向下调整
        for (int i = (end - 1) / 2; i >= 0; i--) {
            adjustDown(array, i, end);
        }
        // 交换后向下调整
        while (end > 0) {
            swap(array, 0, end);
            adjustDown(array, 0, end - 1);
            end --;
        }
    }

    private static void adjustDown(int[] array, int parent, int end) {
        // 默认最大子结点
        int child = 2 * parent + 1;
        // 循环
        while (child <= end) {
            // 找出最大子节点
            if (child + 1 <= end && array[child + 1] > array[child]) {
                child += 1;
            }
            // 对比最大子结点和父亲结点
            if (array[child] > array[parent]) {
                swap(array, child, parent);
                parent = child;
                child = 2 * parent + 1;
            } else {
                // 子树都是大根堆，无需调整
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
