import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-08-2021/8/29
 * Time: 0:56
 */
public class TestDemo {
    public static void main(String[] args) {

    }

    /**
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
     *
     * 链接：https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof
     *
     *  状态：f(n): 第 n 天最大利润
     *  状态方程: f(n) = max(f(n - 1), prices[n] - minPrice）
     *      prices[n]： 当天股价
     *      minPrice: 前n天最小股价
     *  初始状态 f(0) = prices[0]
     *  返回值：f(prices.length - 1)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int[] dp = new int[n];
        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
        }
        return dp[n - 1];
    }

    /**
     * 空间复杂度优化 O(n) -> O(1)
     */
    public int maxProfit1(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int profit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            profit = Math.max(profit, prices[i] - minPrice);
        }
        return profit;
    }
}
