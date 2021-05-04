package thread_0503;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *      打印所有的线程
 * User: hong yaO
 * Date: 2021-05-2021/5/3
 * Time: 17:10
 */
public class ThreadState {
    public static void main(String[] args) {
        //打印所有的线程
        for (Thread.State item : Thread.State.values()) {
            System.out.println(item);
        }
    }
}
