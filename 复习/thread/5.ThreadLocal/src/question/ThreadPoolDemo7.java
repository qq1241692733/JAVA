package question;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/8
 * Time: 20:28
 */
public class ThreadPoolDemo7 {
    /**
     * 2. ThreadLocal 使用：
     *    1.set(T): 将变量存放到线程中
     *    2.get(): 从线程中取得私有变量
     *    3.remove()： 从线程中移除私有变量
     *
     *    4. inutialValue: 初始化
     * 	     inutialValue + get 正常存取操作
     * 	     inutialValue + set  + get  不会执
     *       行初始化方法，先执行 set 方法，再执行get方法
     * 	    为什么 set 之后不会执行初始化，
     *      5. withInitial: 初始化
    */
    // 创建 ThreadLocal
    static ThreadLocal<String> threadLocal =
            new ThreadLocal<>();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String tname = Thread.currentThread().getName();

                    threadLocal.set(tname);
                    System.out.println(String.format("线程：%s 设置了值：%s",
                            tname,tname));
                    printTName();
                } finally {
                    threadLocal.remove();
                }

            }
        },"t1");
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String tname = Thread.currentThread().getName();

                    threadLocal.set(tname);
                    System.out.println(String.format("线程：%s 设置了值：%s",
                            tname, tname));
                    printTName();
                } finally {
                    threadLocal.remove();
                }
            }
        }, "t2");
        t2.start();

    }

    private static void printTName() {
        String tname = Thread.currentThread().getName();
        // 得到存放再 ThreadLocal  中的值
        String res = threadLocal.get();
        System.out.println(String.format("线程：%s 取得了值: %s",
                tname,res));
    }

}
