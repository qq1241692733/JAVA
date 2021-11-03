package safe.a_unsafe;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/2
 * Time: 11:46
 */

/**
 *  volatile 不能解决原子性问题
 */
public class ThreadDemo4 {
    static class Counter {
        private volatile int num = 0;
        private final int maxSize = 100000;
        public int getNum() {
            return num;
        }

        public void incrment() {
            for (int i = 0; i < maxSize; i++) {
                num++;
            }
        }
        public void decrment() {
            for (int i = 0; i < maxSize; i++) {
                num--;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                counter.incrment();
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                counter.decrment();
            }
        });
        t2.start();
        t1.join();
        t2.join();
        System.out.println("使用volatile修饰后");
        System.out.println("num:" + counter.getNum());
    }
}
