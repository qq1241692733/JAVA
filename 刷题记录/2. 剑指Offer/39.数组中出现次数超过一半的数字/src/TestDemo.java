import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/13
 * Time: 20:41
 */
public class TestDemo {
    public static void main(String[] args) {

    }
    public static int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
    public static int majorityElement2(int[] nums) {
        int num = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) num = nums[i];
            if (num == nums[i]) {
                count ++;
            }else {
                count --;
            }
        }
        return num;
    }
}
