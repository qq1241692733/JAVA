/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-08-2021/8/25
 * Time: 13:42
 */
public class TestDemo {
    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,5,6,7,9};
        System.out.println(missingNumber(nums));
    }
    public static int missingNumber(int[] nums) {
        int right = nums.length - 1;
        int left = 0;
        while (left <= right) {
            int min = (left + right) / 2;
            if (nums[min] > min) {
                right = min - 1;
            }else {
                left = min + 1;
            }
        }
        return left;
    }
}
