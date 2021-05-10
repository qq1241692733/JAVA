import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-04-2021/4/19
 * Time: 17:34
 */
public class TestDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int left = i ;
            int right = i ;

            while (left >= 0) {
                left --;
                if (arr[left] < arr[i]) {
                    System.out.print(arr[left] + " ");
                }
            }
            if (left < 0) {
                System.out.print(-1 + " ");
            }

            while (right <= 0) {
                right ++;
                if (arr[right] < arr[i]) {
                    System.out.print(arr[right]);
                }
            }
            if (right >= n) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
