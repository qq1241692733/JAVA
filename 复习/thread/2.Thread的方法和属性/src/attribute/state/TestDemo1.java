package attribute.state;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/1
 * Time: 14:29
 */

public class TestDemo1 {
    /**
     *  NEW: 新建状态，没有调用 start() 之前
     *  RUNNABLE: 运行状态（Running 执行中(得到时间片)， Ready 就绪）
     *  BLOCKED: 阻塞
     *  WAITING: 等待，没有明确的等待时间 wait()
     *  TIMED_WAITING: 超时等待状态，有明确等待时间，如 Sleep(XXX)
     *  TERMINATED: 终止
     */
    public static void main(String[] args) {
        for (Thread.State item: Thread.State.values()) {
            System.out.println(item);
        }
    }
}
