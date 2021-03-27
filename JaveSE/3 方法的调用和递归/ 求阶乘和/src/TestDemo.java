/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-01-2021/1/4
 * Time: 22:00
 */
public class TestDemo {
    public static void main(String[] args) {
        System.out.println(factorAdd(3));
    }

    public static int factorAdd(int n) {
        int num = 1;
        int ret = 0;
        for (int j = 1; j <= n; j++) {
            num *= j;
            ret += num;
        }
        return ret;
    }
}
