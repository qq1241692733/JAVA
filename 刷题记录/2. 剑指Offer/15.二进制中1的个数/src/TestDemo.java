/**
 * Created with IntelliJ IDEA.
 * Description:
 位运算
 * User: hong yaO
 * Date: 2021-09-2021/9/12
 * Time: 16:25
 */
public class TestDemo {
    public static void main(String[] args) {

    }

    /**
     * 左移 <<：丢弃最高位，0补最低位
     * 右移 >>：符号位不变，左边补上符号位，
     *          正数前面补零，负数前面补1
     * 无符号右移 >>>：忽略了符号位扩展，0补最高位
     */
    public static int hammingWeight1(int n) {
        int res = 0;
        while (n != 0) {
//            if ((n & 1) == 1) {
//                res++;
//            }
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }

    public static int hammingWeight2(int n) {
        int res = 0;
        while (n != 0) {
            n &= n - 1;
            res ++;
        }
        return res;
    }
}
