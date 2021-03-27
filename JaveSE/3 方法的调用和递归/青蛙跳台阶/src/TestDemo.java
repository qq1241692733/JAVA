/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-01-2021/1/4
 * Time: 23:14
 */
public class TestDemo {
    public static void main(String[] args) {
        System.out.println(jump(6));
    }
    public static int jump(int n) {
        int res =0;
        if (n <1) {
            return res = -1;
        }
        if (n ==1 || n ==2) {
            return res = n;
        }else{
            return jump(n-1) + jump(n-2);
        }
    }
}
