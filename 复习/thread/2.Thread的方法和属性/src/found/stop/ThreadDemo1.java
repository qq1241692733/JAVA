package found.stop;

/**
 * Created with IntelliJ IDEA.
 * Description:
     1. 使用全局自定义的变量来终止线程
     拿到终止指令后，需要执行完当前任务才会终止
     2. 使用线程提供的终止方法 Interrupt() 来终止线程
     使用全局自定义标识终止线程在执行的时候比较温柔，当收到终止指令后会把当前手头任务执行完再终止，使用interrupt 在收到终止指令后会立刻结束执行
     3. 使用线程提供的方法 stop 来终止线程
     stop不会释放资源会带来风险，不会释放线程里的资源，已被废弃
 * User: hong yaO
 * Date: 2021-09-2021/9/28
 * Time: 16:14
 */
public class ThreadDemo1 {
    /**
     * 使用全局自定义变量终止线程
            在拿到终止指令后，不会立刻终止，执行完当前任务才会终止，而interrupt 会立刻终止线程
            在 t2 将 flag置为 1 时，t1 while 已经判断过了，刚好在sleep等待时，所以会再次打印一次正在转账

     */
    private static boolean flag = false;
    public static void main(String[] args) {
        // 转账线程
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
//                while (!flag) {
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("正在转账");
//                }
//                System.out.println("终止转账");
                while (true) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("正在转账");
                    if (flag) break;
                }
                System.out.println("终止转账");
            }
        });
        t1.start();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(310);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 改变变量的状态来终止线程的执行
                System.out.println("停止交易，有内鬼");
                flag = true;
            }
        });
        t2.start();
    }
}
