import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-11-2021/11/22
 * Time: 19:33
 */
class Solution {
    int[] nums = null;
    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int[] ans = nums.clone(); // 克隆数组
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int j = i + new Random().nextInt(len - i);
            int temp = ans[i];
            ans[i] = ans[j];
            ans[j] = temp;
        }
        return ans;
    }
}
public class TestDemo6 {

}
