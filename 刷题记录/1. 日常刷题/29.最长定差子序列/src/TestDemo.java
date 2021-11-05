import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-11-2021/11/5
 * Time: 11:25
 */
public class TestDemo {
    public static void main(String[] args) {

    }
    public static int longestSubsequence(int[] arr, int difference) {
        int maxNum = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            int tmp =  map.getOrDefault(num - difference, 0) + 1;
            map.put(num, tmp);
            maxNum = Math.max(maxNum, tmp);
        }
        return maxNum;
    }
}
