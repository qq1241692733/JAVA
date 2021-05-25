import com.sun.org.apache.xpath.internal.objects.XObject;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Description:
      方法7
 * User: hong yaO
 * Date: 2021-05-2021/5/23
 * Time: 1:15
 */
public class ThreadPoolDemo10 {
    public static void main(String[] args) {
        Object[] objects = new Object[15];
        ExecutorService service = Executors.newFixedThreadPool(15);
        for (int i = 0; i < 15; i++) {
            int finalI = i;
            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("执行：" + finalI);
                    MyOMMClass myOMMClass = new MyOMMClass();
                    objects[finalI] = myOMMClass;
                }
            });
        }
    }
    static class MyOMMClass {
        private byte[] bytes = new byte[1*1024*1024];
    }
}
