import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/22
 * Time: 20:52
 */
public class TestDemo {
    public static void main(String[] args) {
        int[] nums = {1,2,4,6,10};
        System.out.println(Arrays.toString(twoSum(nums, 8)));
    }
    public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while (true) {
            if (numbers[left] + numbers[right] < target) left ++;
            else if (numbers[left] + numbers[right] > target) right --;
            else if ((numbers[left] + numbers[right]) == target) {
                res[0] = left;
                res[1] = right;
                break;
            }
        }
        return res;
    }
}
