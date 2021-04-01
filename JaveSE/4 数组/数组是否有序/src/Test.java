/**
 * Created with IntelliJ IDEA.
 * Description:
 给定一个整型数组, 判定数组是否有序（递增）
 * User: hong yaO
 * Date: 2020-12-2020/12/14
 * Time: 18:03
 */
public class Test {
    public static void main(String[] args) {
    int[] arr={1,2,3,4,5,6};
    System.out.println(isSorted(arr));
    }
    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            if (array[i]>array[i+1]) {
                return false;
            }
        }
        return  true;
    }
}
