package demo2_6;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2022-02-2022/2/6
 * Time: 12:21
 */
class MyStack {
    Queue<Integer> queue = null;
    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        int n = queue.size() - 1;
        while (n-- > 0) {
            queue.add(queue.poll());
        }
        return queue.poll();
    }

    public int top() {
        int n = queue.size() - 1;
        while (n-- > 0) {
            queue.add(queue.poll());
        }
        int res = queue.peek();
        queue.add(queue.poll());
        return res;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
public class Solution {
    public static String removeDuplicates(String s) {
        char[] arr = s.toCharArray();
        int slow = 0;
        for (int fast = 0; fast < s.length(); fast++) {
            if (slow >= 0 && arr[fast] == arr[slow]) {
                slow--;
            } else {
                arr[++slow] = arr[fast];
            }
        }
        return String.valueOf(arr).substring(0, slow);
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int idx = 0;
        for(int i = 0; i < n; i++) {
            // 根据题意，i为nums下标，是要在[i - k + 1, i] 中选到最大值，只需要保证两点
            // 1.队列头结点需要在[i - k + 1, i]范围内，不符合则要弹出
            while(!deque.isEmpty() && deque.peek() < i - k + 1){
                deque.poll();
            }
            // 2.既然是单调，就要保证每次放进去的数字要比末尾的都大，否则也弹出
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offer(i);

            // 因为单调，当i增长到符合第一个k范围的时候，每滑动一步都将队列头节点放入结果就行了
            if(i >= k - 1){
                res[idx++] = nums[deque.peek()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3);
        System.out.println(Arrays.toString(arr));
        System.out.println("***--------------------------***");
        System.out.println(removeDuplicates("abbaca"));
        Stack<Integer> stack = new Stack<>();
        System.out.println(stack.add(3));
        System.out.println(stack.push(4));
//        System.out.println(stack.peek());
//        System.out.println(stack.pop());
//        stack.peek();
        System.out.println('}' == '(' | '[' == '[' | '(' == '{');
        System.out.println("***--------------------------***");
        Queue<Integer> queue = new LinkedList<>();

        Deque<Integer> deque = new ArrayDeque<>();

//        deque.addFirst(1);
//        deque.addFirst(2);
//        deque.addFirst(3);
//        for (int i : deque) {
//            System.out.print(i);
//        }
        deque.push(1);;
        deque.push(2);
        deque.push(3);
        System.out.println(deque.poll());
        System.out.println(deque.pollFirst());
        System.out.println(deque.peek());
        System.out.println(deque.peekLast());

        for (int i : deque) {
            System.out.print(i);
        }
//        System.out.println(deque.peek());
//        System.out.println(String.valueOf(deque));
//        StringBuilder sb = new StringBuilder("abc");
//        sb.deleteCharAt(1);
//        System.out.println(sb);
//        while (!deque.isEmpty()) {
//            System.out.println(deque.poll());;
//        }
        Stack<Character> stack1 = new Stack<>();
        stack1.push('a');
        stack1.push('b');
        stack1.push('c');
        System.out.println();
        for (char ch : stack1) {
            System.out.print(ch);
        }

    }
}
