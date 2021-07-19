/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-07-2021/7/19
 * Time: 20:57
 */
public class TestDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
        System.out.println(maxSubArray1(arr));
    }
    public static int maxSubArray(int[] nums) {
        if (nums == null) return 0;

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxNum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            maxNum = Math.max(maxNum,dp[i]);
        }
        return maxNum;
    }

    // 简化空间复杂度
    public static int maxSubArray1(int[] nums) {
        if (nums == null) return 0;

        int maxSum = nums[0];
        int dp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp = Math.max(dp + nums[i], nums[i]);
            maxSum = Math.max(maxSum,dp);
        }
        return maxSum;
    }
}
