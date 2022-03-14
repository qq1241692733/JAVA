package demo2_9;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2022-02-2022/2/9
 * Time: 15:46
 */
public class Sort {
    public static void main(String[] args) {
        int[] array = {3,2,1,5,6,4};
        //heapSort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(findKthLargest(array, 2));
    }
    // 找第 k 大元素
    public static int findKthLargest(int[] nums, int k) {
        int end = nums.length - 1;
        for (int i = (end - 1) / 2; i >=0; i--) {
            adjustDown(nums, i,end);
        }
        while (k-- > 1) {
            swap(nums, 0, end);
            end--;
            adjustDown(nums, 0, end);
        }
        return nums[0];
    }
    // 堆排
    public static void heapSort(int[] array) {
        // 1.建大堆
        int end = array.length - 1;
        for (int i = (end - 1) / 2; i >= 0; i--) {
            // 从最后一个非子叶节点向下调整
            adjustDown(array, i, end);
        }
        while (end > 0) {
            swap(array, 0,end);
            end--;
            adjustDown(array, 0,end);
        }
    }
    // 向下调整
    private static void adjustDown(int[] array, int parent, int end) {
        // 1.找到最大子节点
        int child = 2 * parent + 1;  // 左孩子
        while (child <= end) {
            if (child + 1 <= end && array[child + 1] > array[child]) {
                child += 1;
            }
            if (array[child] > array[parent]) {
                swap(array, child, parent);
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
