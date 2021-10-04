package safe.a_unsafe;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/2
 * Time: 11:46
 */
public class ThreadDemo1 {
    static class Counter {
        private int num = 0;
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

    /**
     * 线程不安全： 多线程执行中，程序执行的结果和预期不相符
         ++/--执行过程(是非原子性)：
             1.load(读取)
             2.calc(运行)
             3.save(保存)

         线程不安全原因：
             1.CPU 抢占执行
             2.非原子性；
             3.编译器优化（代码优化）指令重排序
            改变代码执行顺序，单线程下会提升程序执行效率，但是在多线程下回出现混乱，导致线程不安全

             4.可见性问题(内存不可见性)
            使用变量用 volatile 修饰：解决线程可见性问题，禁止指令重回排序

             5. 多个线程修改了同一个变量
     */
    public static void main(String[] args) throws InterruptedException {
        // 单线程，线程安全
        Counter counter = new Counter();

//        Thread thread = new Thread(() -> {
//            counter.incrment();
//            counter.decrment();
//            System.out.println("单线程：" + counter.getNum());
//        });
//        thread.start();
//        thread.join();

        // 多线程
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
        System.out.println("多线程：" + counter.getNum());
    }
}
