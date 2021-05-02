package thread_0502;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *    使用两个线程来打印”AABBCCDD“
 * User: hong yaO
 * Date: 2021-05-2021/5/2
 * Time: 11:33
 */
public class ThreadDemo1 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String data = "ABCD";
                for (char item : data.toCharArray()) {
                    System.out.print(item);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread t1 = new Thread(runnable);
        t1.start();
        Thread t2 = new Thread(runnable);
        t2.start();
    }
}
