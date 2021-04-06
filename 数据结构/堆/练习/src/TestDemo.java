import java.util.Arrays;
import java.util.Comparator;
import java.util.PrimitiveIterator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-01-2021/1/29
 * Time: 11:11
 */
public class TestDemo {
    /**
     * topk问题: 找前 K 个最大的，要建 K 个大小的小堆
     * 找最大的用大小为K的小根堆
     * 找最大的用大小为K的大根堆
     * @param array
     */
    public static void tpk(int[] array, int k) {
        PriorityQueue<Integer> minHeap= new PriorityQueue<>();
        for (int i = 0; i < array.length; i++) {
            if (minHeap.size() < k) {
                minHeap.offer(array[i]);
            }else {
                int top = minHeap.peek();
                if (array[i] > top) {
                    minHeap.poll();
                    minHeap.offer(array[i]);
                }
            }
        }
        for (int j = 0; j < k; j++) {
            System.out.println(minHeap.poll());
        }
    }

    public static void main(String[] args) {
        int[] array = { 27,15,19,18,28,34,65,49,25,37 };
        tpk(array, 4);
    }
    public static void main2(String[] args) {
        /**
         * 大根堆的创建
         * Lambda 表达式 (a, b) -> b - a
         */
        //PriorityQueue<Integer> qu = new PriorityQueue<> ((a, b) -> b - a);
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        pq.offer(1);
        pq.offer(3);
        pq.offer(6);
        pq.offer(2);
        System.out.println(pq.peek());
    }
    public static void main1(String[] args) {
        HeapDemo heapDemo = new HeapDemo();
        int[] array = {27,15,19,18,28,34,69,49,25,37};
        System.out.println(Arrays.toString(array));
        heapDemo.crateBigHeap(array);
        heapDemo.show();
//        heapDemo.push(100);
//        heapDemo.show();
        heapDemo.poll();
        heapDemo.show();
        System.out.println("******************");

        /**
         * 优先级队列： PriorityQueue  底层是小根堆/小顶堆0
         */
        PriorityQueue<Integer> qu = new PriorityQueue<> ();
        qu.offer(10);
        qu.offer(20);
        qu.offer(1);
        qu.offer(30);
        qu.offer(100);
        System.out.println(qu.poll());
        System.out.println(qu.peek());

    }
}
