
import java.util.Arrays;
import java.util.Map;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/17
 * Time: 19:20
 */
public class TestDemo {
    public static void main(String[] args) {
        //int[] a = {-2,-1,1,-2};
        int[] a = {10,2,-5};
        System.out.println(Arrays.toString(asteroidCollision(a)));
    }
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int num : asteroids) {
            if (num < 0) stack.push(num);
            else {
                while (!stack.isEmpty() && stack.peek() > 0) {
                    if (-num > stack.peek()) {
                        stack.pop();
                    } else if (-num < stack.peek()) {
                        ;
                    }else {
                        continue;
                    }
                }
                stack.push(num);
            }
        }
        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}
