import java.awt.event.TextEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/18
 * Time: 19:25
 */
public class TestDemo {
    public static void main(String[] args) {
        int[] arr = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(arr)));
        System.out.println(Arrays.toString(dailyTemperatures1(arr)));
    }
    // 暴力解法
    public static int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int count = 0;
            for (int j = i; j < len; j++) {
                if (temperatures[j] <= temperatures[i]) {
                    count ++;
                }else {
                    break;
                }
            }
            if (count == len - i && temperatures[len -1] <= temperatures[i]) {
                res[i] = 0;
            }else {
                res[i] = count;
            }
        }
        return res;
    }
    // 栈
    public static int[] dailyTemperatures1(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int n = stack.pop();
                res[n] = i - n;
            }
            stack.push(i);
        }
        return res;
    }
}
