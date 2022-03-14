package demo2_9;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2022-02-2022/2/9
 * Time: 14:13
 */
class MinStack {
    Stack<Integer> stack = null;
    Stack<Integer> minStack = null;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        minStack.push(Math.min(minStack.peek(), val));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
public class TestDemo {

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(46);
        stack.push(46);
        stack.push(47);
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        stack.push(47);
        System.out.println(stack.top());
        System.out.println(stack.getMin());
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, map.getOrDefault(1, 0) + 1);
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>();
        int [] arr= new int[3];
        for (int i : arr) {
            i = 1;
        }
        System.out.println(Arrays.toString(arr));

    }

}
