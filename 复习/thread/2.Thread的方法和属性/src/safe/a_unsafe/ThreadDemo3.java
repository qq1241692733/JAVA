package safe.a_unsafe;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/2
 * Time: 11:46
 */

// 修改 Threademo1，将 num 设设置为两个变量
public class ThreadDemo3 {
    static class Counter {
        private int num = 0;
        private final int maxSize = 100000;
        public int getNum() {
            return num;
        }

        public int incrment() {
            int num1 = 0;
            for (int i = 0; i < maxSize; i++) {
                num1++;
            }
            return num1;
        }
        public int decrment() {
            int num2 = 0;
            for (int i = 0; i < maxSize; i++) {
                num2--;
            }
            return num2;
        }
    }

    /**
     * 5. 多个线程修改了同一个变量
     */

    private static int num1 = 0;
    private static int num2 = 0;
    public static void main(String[] args) throws InterruptedException {
        // 单线程，线程安全
        Counter counter = new Counter();


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                num1 = counter.incrment();
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                num2 = counter.decrment();
            }
        });
        t2.start();
        t1.join();
        t2.join();
        System.out.println("多线程：" + counter.getNum());
    }
}
