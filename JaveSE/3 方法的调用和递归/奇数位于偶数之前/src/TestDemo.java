import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 调整数组顺序使得奇数位于偶数之前。调整之后，不关心大小顺序。
 * User: hong yaO
 * Date: 2021-01-2021/1/4
 * Time: 22:19
 */
public class TestDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        func(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void func(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] % 2 != 0) {
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
    }
}
