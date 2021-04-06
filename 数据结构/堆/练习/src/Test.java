import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-01-2021/1/31
 * Time: 19:26
 */
public class Test {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return 0;
            }
        })

        int[][] arr = new int[3][];
        arr[1] = new int[] {1,2};

        ArrayList<List<Integer>> array = new ArrayList<>();
        array.add();

        for(int i = 0; i < nums1.length; i ++) {
            for(int j = 0; j < nums2.length; j ++) {

                array.add({nums1[i], nums2[j]});
            }
        }
        for(int i = 0; i < pq.size(); i ++) {
            int[] = new int[] {nums1[i]}
            if(pq.size() < k) {
                pq.offer(array[i])
            }else {
                int
            }
        }
    }
}
