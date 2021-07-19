/**
 * Created with IntelliJ IDEA.
 * Description:
        我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
     请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，从同一个方向看总共有多少种不同的方法？
        牛客网
        https://www.nowcoder.com/questionTerminal/72a5a919508a4251859fb2cfb987a0e6
 * User: hong yaO
 * Date: 2021-07-2021/7/19
 * Time: 19:23
 */
public class TestDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            System.out.println(rectCover(i));
        }
    }
    public static int rectCover(int target) {
        if (target == 0) return 0;
        if (target == 1) return 1;
        int[] dp = new int[target + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }
}
