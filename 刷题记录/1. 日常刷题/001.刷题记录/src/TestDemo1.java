import java.util.Arrays;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:  两数之和
 * User: hong yaO
 * Date: 2021-11-2021/11/16
 * Time: 7:02
 */
public class TestDemo1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3,2,4}, 6)));
    }
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
