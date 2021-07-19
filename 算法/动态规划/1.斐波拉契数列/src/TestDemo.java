import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-07-2021/7/19
 * Time: 15:12
 */
public class TestDemo {
    public static void main(String[] args) {
        System.out.println(fib1(10));
        System.out.println(fib2(10));
        System.out.println(fib3(10));
    }

    //DP
    public static int fib3(int n) {
        if (n <= 0) return 0;
        int[] array = new int[n + 1];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i <= n ; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }

    //递归
    public static int fib1(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1 || n == 2) {
            return 1;
        }
        return fib1(n-1) + fib1(n-2);
    }

    //非递归
    public static int fib2(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int f1 = 0;
        int f2 = 1;
        int f3 = 1;
        for (int i = 1; i < n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
}
