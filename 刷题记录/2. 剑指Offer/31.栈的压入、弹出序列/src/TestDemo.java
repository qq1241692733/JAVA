import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/20
 * Time: 12:19
 */
public class TestDemo {
    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,5,3,1,2};
        System.out.println(validateStackSequences(pushed,popped));
    }
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> push = new Stack<>();
        int poi = 0;
        for (int i = 0; i < pushed.length; i++) {
            push.push(pushed[i]);
            while (!push.isEmpty() && push.peek() == popped[poi]) {
                push.pop();
                poi ++;
            }
        }
        return push.isEmpty();
    }
}
