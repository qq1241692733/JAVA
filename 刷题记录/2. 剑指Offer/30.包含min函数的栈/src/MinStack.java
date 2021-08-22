import java.util.LinkedList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-08-2021/8/22
 * Time: 0:00
 */
public class MinStack {
    Stack<Integer> stack, minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }
    public void pop() {
       // if (stack.pop().equals(minStack.peek())) {
        if (stack.pop() == minStack.peek()) {
            minStack.pop();
        }
    }
    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
