import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/19
 * Time: 19:58
 */
public class TestDemo {
    public static void main(String[] args) {
        int[] a = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(a));
    }
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxNum = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]) {
                int height = heights[stack.peek()];
                stack.pop();
                int width = i - stack.peek() - 1;
                maxNum = Math.max(maxNum, height * width);
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            int height = heights[stack.peek()];
            stack.pop();
            int width = heights.length - stack.peek() - 1;
            maxNum = Math.max(maxNum, height * width);
        }
        return maxNum;
    }
}
