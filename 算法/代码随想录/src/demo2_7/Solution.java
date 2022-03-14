package demo2_7;

import java.util.*;
import java.util.concurrent.BlockingDeque;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2022-02-2022/2/7
 * Time: 16:47
 */
public class Solution {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        // 入栈
        stack.push(1);  // 返回入栈元素
        stack.add(2);  // 返回 boolean 类型
        // 出栈，返回出栈元素
        stack.pop();
        // 返回栈顶元素
        stack.peek();

        Queue<Integer> queue = new LinkedList<>();
        // 入队列
        queue.offer(1);  // 返回 boolean 类型
        queue.add(2);  // 返回 boolean 类型
        // 出队列，返回出队列元素
        queue.poll();
        // 返回队头元素
        queue.peek();


        Deque<Integer> deque = new ArrayDeque<>();
        Deque<Integer> deque1 = new LinkedList<>();
        // 入队列，返回 boolean 类型
        deque.addFirst(1); //
        deque.addLast(1);  // 入队列

        // 出队列
        deque.pollFirst();  // 队头
        deque.pollLast();   // 队尾

        // 返回队头元素和队尾元素
        deque.peekFirst();  // 队头
        deque.peekLast();   // 队尾

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 10; i > 0; i--) {
            priorityQueue.add(i);
        }
        System.out.println();
        System.out.println(priorityQueue);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1,Integer o2){
                return o2-o1;
            }
        });

        PriorityQueue<Integer> maxHeap1 = new PriorityQueue<>();
    }
}
