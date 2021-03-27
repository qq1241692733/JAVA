/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-01-2021/1/4
 * Time: 23:04
 */
public class TestDem {
    public static void main(String[] args) {
        printf(123);
    }
    public static void printf(int n) {
        if(n > 9) {
            printf(n/10);
        }
        System.out.print(n%10+" ");
    }
}
