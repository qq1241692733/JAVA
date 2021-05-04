package thread_0503;

/**
 * Created with IntelliJ IDEA.
 * Description:
        Thread.currentThread().isInterrupted()
         Thread.interrupted() 会产生复位
 * User: hong yaO
 * Date: 2021-05-2021/5/3
 * Time: 11:28
 */
public class StopThread4 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    //System.out.println(Thread.interrupted());
                    /**
                     * Thread.interrupted() :
                     *      结果除了第一次为 true剩下都为 false
                     *      执行判断线程终止为 true 后就会将状态复位为 false
                     * Thread.currentThread().isInterrupted():
                     *       不会清楚标志位
                     *       拿到当前线程的 interrupted 状态
                     */

                    System.out.println(Thread.currentThread().isInterrupted());
                }
            }
        });
        t1.start();
        t1.interrupt();
    }
}
