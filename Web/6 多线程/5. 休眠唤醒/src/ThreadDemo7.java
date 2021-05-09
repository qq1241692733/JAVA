import java.util.Date;
import java.util.concurrent.locks.LockSupport;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-05-2021/5/9
 * Time: 12:21
 */
public class ThreadDemo7 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程进入休眠" + new Date());
                //LockSupport.parkUntil(1000);  /
                LockSupport.parkUntil(System.currentTimeMillis() + 1000);// 到这个点醒来
                System.out.println("线程终止休眠" + new Date());
            }
        }).start();
    }
}
