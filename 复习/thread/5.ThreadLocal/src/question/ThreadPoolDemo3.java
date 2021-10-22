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
public class ThreadPoolDemo3 {
    /**
     * 1. ThreadLocal 的引入：
     *  问题的引入
     *  需求1：
     *      使用最高效的方法实现2个时间格式化
     */
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Date date = new Date(2000);
                myFormatTime(date);
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Date date = new Date(2000);
                myFormatTime(date);
            }
        });
        t2.start();
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
