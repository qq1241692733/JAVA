/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/2
 * Time: 18:27
 */
public class TestDemo {
    public static void main(String[] args) {

    }
    public int[] exchange(int[] nums) {
        int j = nums.length - 1;
        int i = 0;
        while (i < j) {
            if (nums[i] % 2 == 0) { // 左偶数
                if (nums[j] % 2 == 1) {  //右奇数
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                    i ++;
                }
                j --;  // 右偶数
            }else {
                i ++;  //左奇数
            }
        }
        return nums;
    }
}
