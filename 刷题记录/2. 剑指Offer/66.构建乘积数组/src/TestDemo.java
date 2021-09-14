import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/14
 * Time: 10:38
 */
public class TestDemo {
    public static void main(String[] args) {
        int[] a= {1,2,3,4,5};
        System.out.println(Arrays.toString(constructArr2(a)));
    }
    // 暴力解法
    public static int[] constructArr1(int[] a) {
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int tmp = 1;
            for (int j = 0; j < a.length; j++) {
                if (i != j) {
                    tmp *= a[j];
                }
            }
            b[i] = tmp;
        }
        return b;
    }

    // dp
    public static int[] constructArr2(int[] a) {
        int[] b = new int[a.length];
        if(a.length == 0) return b;
        b[0] = 1;
        for (int i = 1; i < a.length; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        int tmp = 1;
        for (int i = a.length - 2; i >= 0 ; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }
}
