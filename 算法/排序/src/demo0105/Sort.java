package demo0105;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2022-01-2022/1/5
 * Time: 17:29
 */
public class Sort {

    // 1.直接插入排序，类比扑克牌
    public static void insertSort(int[] array) {
        // 一张一张揭牌，手中从 0张开始揭牌
        for (int i = 0; i < array.length; i++) {
            // 揭到一张扑克牌，本来放在最后
            int curNum = array[i];
            int j = i - 1;
            // 一张一张向前对比
            while (j >= 0 && curNum < array[j]) {
                // 手中的牌小时，将大的牌像后移动一个位置
                array[j + 1] = array[j];
                j --;
            }
            // 直到手中的牌大了，插入上一张牌移动后的空位
            array[j + 1] = curNum;
        }
    }

    // 2.希尔排序：使用分组的方法直接插入排序，序列逐渐趋于有序化
    public static void shellSort(int array[]) {
        int gap = array.length;
        while (gap > 1) {
            insertSortGap(array, gap);
            gap = (gap / 3) + 1;
        }
        insertSortGap(array, 1);
    }
    // 此处就是直接插入排序
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
            // 遍历未排序序列，找出最小下标
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // 放在最前边
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    // 4.堆排序
    public static void heapSort(int[] array) {
        int end = array.length - 1;
        // 从最后一个非子叶结点开始向下调整，建大根堆
        for (int i = (end - 1) / 2; i >= 0; i--) {
            adjustDown(array, i, end);
        }
        while (end > 0) {
            // 交换
            swap(array, 0, end);
            adjustDown(array, 0, end - 1);
            end--;
        }
    }
    // 向下调整
    private static void adjustDown(int[] array, int parent, int end) {
        // 最大孩子
        int child = 2 * parent + 1;
        // 向下调整后，交换后的子结点子树可能已经不是大根堆，需要继续从子节点开始向下调整因此放在 while 循环中
        while (child <= end) {
            // 1.找出最大子结点
            if (child + 1 <= end && array[child + 1] > array[child]) {
                // 如果存在右孩子，并且右孩子大于左孩子，更新最大孩子结点
                child += 1;
            }  // else: 没有右孩子，那么最大子结点就为左孩子
            // 此时的 child 为最大子结点
            if (array[child] > array[parent]) {
                // 如果最大孩子结点大于父亲结点，交换
                swap(array, child, parent);
                // 从子结点开始下一轮调整
                parent = child;
                child = 2 * parent + 1;
            } else {
                break;
            }
        }
    }
    // 交换
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}
