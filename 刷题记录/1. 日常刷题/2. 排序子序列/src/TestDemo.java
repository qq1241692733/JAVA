import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *  输入 n  和n长度的序列
    输出 序列升序或降序排列的子序列个数最小值
    如   输入: 121  输出:2
        输入: 111  输出:1

 * User: hong yaO
 * Date: 2021-04-2021/4/13
 * Time: 10:22
 */
public class TestDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
//        for (int i: arr) {
//            i = scanner.nextInt();
//        }
        int i = 0;
        int ret = 0;
        while (i < n) {
            arr[i] = scanner.nextInt();
            i++;
        }
        i = 1;
        while (i < n) {
            if (arr[i] == arr[i - 1]) {
                while (i < n && arr[i] == arr[i - 1]) {
                    i ++;
                }
                if (i == n) ret ++;
            }
            if (i < n && arr[i] > arr[i-1]) {
                while (i < n && arr[i] > arr[i -1]) {
                    i ++;
                }
                if (i == n-1) ret ++;
                ret ++;
                i ++;
            }
            if (i < n && i < n && arr[i] < arr[i - 1]) {
                while (i < n && arr[i] < arr[i-1]) {
                    i ++;
                }
                if (i == n-1) ret ++;
                ret ++;
                i ++;
            }
        }
        System.out.println(ret);
    }
}
