package question;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/8
 * Time: 20:28
 */
public class ThreadPoolDemo4 {
    /**
     * 1. ThreadLocal 的引入：
     * 问题的引入
     *  需求 2：
     *  使用最高效的方法实现 10个时间格式化
     */
    public static void main(String[] args) {
        for (int i = 1; i < 11; i++) {
            int finalI = i;
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    Date date = new Date(1000 * finalI);
                    myFormatTime(date);
                }
            });
            t1.start();
        }
    }

    /**
     * 自定义时间格式化
     * @param date
     */
    private static void myFormatTime(Date date) {
        SimpleDateFormat dateFormat =
                new SimpleDateFormat("mm:ss");
        String res = dateFormat.format(date);
        System.out.println(res);
    }
}
