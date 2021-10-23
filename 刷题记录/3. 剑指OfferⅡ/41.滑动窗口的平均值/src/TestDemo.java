import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/23
 * Time: 21:20
 */
class MovingAverage {

    /** Initialize your data structure here. */
    private int length = 0;
    private Queue<Integer> queue;
    private double sum = 0;
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        length = size;
    }

    public double next(int val) {
        if (queue.size() == length) {
            sum -= queue.remove();
        }
        queue.offer(val);
        sum += val;
        return sum / queue.size();
    }
}
public class TestDemo {
    public static void main(String[] args) {

    }
}
