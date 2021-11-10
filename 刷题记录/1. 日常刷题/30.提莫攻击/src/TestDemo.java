/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-11-2021/11/11
 * Time: 5:45
 */
public class TestDemo {
    public static void main(String[] args) {
        System.out.println(findPoisonedDuration(new int[]{1,1}, 2));
    }
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int result = 0;
        int preTime = -1;  // 注意 防止0开头
        for (int i = 0; i < timeSeries.length; i++) {
            if (timeSeries[i] > preTime) {
                result += duration;
            } else {
                result += duration - (preTime + 1 - timeSeries[i]); // 重复时间：上次中毒结束时间减去这次开始时间
            }
            preTime = timeSeries[i] + duration - 1;
        }
        return result;
    }
}
