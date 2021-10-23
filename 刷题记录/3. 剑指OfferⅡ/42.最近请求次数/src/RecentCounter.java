import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/23
 * Time: 21:37
 */
public class RecentCounter {
    private Queue<Integer> queue = null;
    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        int minTime = t - 3000;
        while (!queue.isEmpty() && queue.peek() < minTime) {
            queue.poll();
        }
        queue.offer(t);
        return queue.size();
    }

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));
    }
}
