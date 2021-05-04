package thread_0503;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-05-2021/5/3
 * Time: 18:07
 */
public class ThreadSafe {
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

        public static void main(String[] args) {
            Counter counter = new Counter();
            counter.incrment();
            counter.decrment();
            System.out.println(counter.getNum());
        }
    }
}
