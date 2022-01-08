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
        // 此时数组已经趋于有序， gap = 1 时，相当于直接插入排序
        insertSortGap(array,1);
    }

    private static void insertSortGap(int[] array, int gap) {
        // 对 array 中相隔 gap 的数进行排序，类比直接插入排序
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

    // 3.直接选择排序
    public static void selectSort(int[] array) {
        // 从无序区间选择最小数交换到最无序区间的最前边  有序区间[0,i)   无序区间[i,len]
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            // 寻找最小值下标
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // 找到后，交换位置
            int tmp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = tmp;
        }
    }

    // 4.堆排
    public static void heapSort(int[] array) {
        // 1.创建大根堆
        int end = array.length;
        for (int i = (end - 1) / 2; i >= 0 ; i--) {
            // 从最后一个非子叶结点开始向下调整
            adjustDown(array, i, end);
        }
        // 2. 选择最大数交换位置
        while (end > 0) {
            // 将最大数换到最后边
            swap(array, 0, end);
            // 缩小无序区间
            end --;
            //再向下调整
            adjustDown(array, 0, end);
        }
    }
    // 向下调整：调整为父亲结点值大于子结点，在找到最大子结点后与父亲结点对比交换
    private static void adjustDown(int[] array, int parent, int end) {
        // 默认最大子结点
        int child = 2 * parent + 1;
        // 有可能要调整的父亲结点是个很小的数，与最大子结点交换后依然小于子结点，还需继续调整。所以要 while 循环里，直到大于子结点或者没有子结点结束循环
        while (child <= end) {
            // 如果存在右孩子，并且右孩子大于左孩子，更新最大孩子结点
            if (child + 1 <= end && array[child + 1] > array[child]) {
                child += 1;
            }
            // 此时的 child 已经为为最大子结点
            if (array[child] > array[parent]) {
                // 如果最大孩子结点大于父亲结点，交换
                swap(array, child, parent);
                // 从子结点开始下一轮调整
                parent = child;
                child = 2 * parent + 1;
            } else {
                // 大于子结点，跳出循环
                break;
            }
        }
    }
    // 交换位置
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // 5.冒泡排序
    public static void bubbleSort(int[] array) {
        // 无序区间[0，len-i], i表示有序区间 数的个数
        for (int i = 0; i < array.length; i++) {
            // 遍历无序区间
            for (int j = 0; j < array.length - i - 1; j++) {
                // 对比交换相邻两个数较大的数
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    // 6.快排
    public static void quickSort(int[] array) {
        quick(array, 0, array.length - 1);
    }
    // 递归
    private static void quick(int[] array, int low, int high) {
        // 结束条件
        if (low >= high) return;
        // 确定大小两区间的 分割点
        int piv = pivot(array, low, high);
        // 对两边区间递归
        quick(array, low, piv);
        quick(array, piv + 1, high);
    }
    // 划分大小区间，并返回分割点下标
    private static int pivot(int[] array, int start, int end) {
        // 将待排序区间的首位 确定为基准数
        int piv = array[start];
        // 开始寻找基准数该在的位置
        while (start < end) {
            // 从右开始找小于基准数的数
            while (array[end] >= piv) {
                end --;
            }
            // 放在前边，因为小于基准数的数不应该出现在基准数之后
            array[start] = array[end];
            // 从左开始找大于基准数的数
            while (array[start] <= piv) {
                start ++;
            }
            // 放在后边，因为大于基准数的数不应该出现在基准数之前
            array[end] = array[start];
        }
        // 左右指针相遇位置，就是数组有序后基准数应该在的位置。因为上边一轮交换后，该位置左边全都小于基准数，右边全大于基准数
        array[end] = piv;
        // 返回基准数应该在的位置，及数组有序后基准数在的位置
        return end;
    }

    // 7.归并排序
    public static void mergeSort(int[] array) {
        mergeSortInternal(array, 0, array.length - 1);
    }
    // 递归
    private static void mergeSortInternal(int[] array, int low, int high) {
        // 结束条件
        if (low >= high) return;
        int mid = (low + high) / 2;
        // 递归左右两部分
        mergeSortInternal(array, low, mid);
        mergeSortInternal(array, mid + 1, high);
        // 合并
        merge(array, low, mid, high);
    }
    // 合并两个有序数组 数组1：[low, mid]  数组2：[mid+1, high]
    private static void merge(int[] array, int low, int mid, int high) {
        // 两个区间的起始位置
        int s1 = low;
        int s2 = mid + 1;
        // 归并结果接受数组
        int tmp[] = new int[high - low + 1];
        int k = 0;
        // s1 和 s2都不出界时，对比较小的数放在前边
        while (s1 <= mid && s2 <= high) {
            if (array[s1] <= array[s2]) {
                tmp[k++] = array[s1++];
            }
            if (array[s2] <= array[s1]) {
                tmp[k++] = array[s2++];
            }
        }
        // 两个区间剩余部分，添加到后边即可
        while (s1 <= mid) {
            tmp[k++] = array[s1++];
        }
        while (s2 <= high) {
            tmp[k++] = array[s2++];
        }
        // 拷贝回原数组
        for (int i = 0; i < tmp.length; i++) {
            // 注意拷贝的区间是 low 开始
            array[low + i] = tmp[i];
        }
    }

}

