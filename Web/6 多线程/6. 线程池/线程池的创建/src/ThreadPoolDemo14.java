import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-05-2021/5/23
 * Time: 10:58
 */
public class ThreadPoolDemo14 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,
                0, 0,TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(1000));
        executor.submit(new Callable<Integer>() {

        });
    }
}
