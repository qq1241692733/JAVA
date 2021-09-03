/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/3
 * Time: 17:16
 */
public class TestDemo {
    public static void main(String[] args) {

    }
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int left = 0;
        int right = nums.length - 1;
        while (nums[right] > target && left < right) {
            right --;
        }
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                left ++;
            }else if (nums[left] + nums[right] > target) {
                right --;
            }else {
                res[0] =nums[left];
                res[1] = nums[right];
                break;
            }
        }
        return res;
    }
}
