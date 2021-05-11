import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-05-2021/5/11
 * Time: 8:50
 */
public class TestDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,1,4};
        System.out.println(findRepeatNumber(arr));
    }
    public static int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }
}
