import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-08-2021/8/24
 * Time: 23:02
 */
public class TestDemo {
    public static void main(String[] args) {
        int[] array = {1,4};
        System.out.println(search2(array, 4));
    }
    public static int search1(int[] nums, int target) {
        int count = 0;
        for(int num : nums) {
            if (num == target) {
                count ++;
            }
        }
        return count;
    }

    /**
     * 注意：while (left <= right)
     */
    public static int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = 0;
        while (left <= right) {
            int min = (left + right) / 2;
            if (target == nums[min]) {
                index = min;
                break;
            }else if (target < nums[min]) {
                right = min - 1;
            }else if (target > nums[min]) {
                left = min + 1;
            }
        }
        int i = index;
        int count = 0;
        while (i < nums.length && nums[i] == target) {
            i ++;
            count ++;
        }
        i = index - 1;
        while (i >= 0 && nums[i] == target) {
            i --;
            count ++;
        }
        return count;
    }
}
