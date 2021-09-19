/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/17
 * Time: 18:47
 */
public class TestDemo {
    public static void main(String[] args) {

    }
    public static int lastRemaining(int n, int m) {
        int res = 0;
        int gap = 2;
        while (gap <= n) {
            res = (res + m) % gap;
            gap ++;
        }
        return res;
    }
}
