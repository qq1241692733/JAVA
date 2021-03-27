/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-01-2021/1/4
 * Time: 21:42
 */
public class TestDemo {
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,4,4,5,5};
        System.out.println();
        System.out.println(findSingLenum(arr));
    }
    public static int findSingLenum(int[] arr) {
        int ret = arr[0];
        for (int i = 1; i < arr.length; i++) {
            ret = ret ^ arr[i];
        }
        return ret;
    }
}
