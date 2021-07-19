/**
 * Created with IntelliJ IDEA.
 * Description:
     输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。

     要求时间复杂度为O(n)。

     示例1:

     输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
     输出: 6
     解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * User: hong yaO
 * Date: 2021-07-2021/7/19
 * Time: 19:35
 */
public class TestDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
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
