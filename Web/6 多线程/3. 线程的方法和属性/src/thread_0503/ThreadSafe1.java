package thread_0503;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-05-2021/5/3
 * Time: 18:07
 */
public class ThreadSafe1 {
    static class Counter{
        private int num = 0;
        private final int maxSize = 100000;

        public void incrment() {
            for (int i = 0; i < maxSize; i++) {
                num ++;
            }
        }
        public void decrment() {
            for (int i = 0; i < maxSize; i++) {
                num --;
            }
        }
        public int getNum() {
            return num;
        }

        public static void main(String[] args) throws InterruptedException {
            Counter counter = new Counter();

            Thread t1 = new Thread(() -> {
                counter.incrment();
            });
            Thread t2 = new Thread(() -> {
                counter.decrment();
            });
            t1.start();
            //t1.join();
            t2.start();
            t1.join();
            t2.join();
            System.out.println(counter.getNum());  //结果非零
        }
    }
}

