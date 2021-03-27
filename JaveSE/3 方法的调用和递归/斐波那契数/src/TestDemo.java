/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-01-2021/1/4
 * Time: 21:56
 */
public class TestDemo {
    public static void main(String[] args) {
        System.out.println(fib(10));
    }
    public static int fib(int n) {
        int f1 = 1;
        int f2 = 1;
        int f3 = 1;
        for (int i = 3; i <= n ; i++) {
            f3 = f1+f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
}
