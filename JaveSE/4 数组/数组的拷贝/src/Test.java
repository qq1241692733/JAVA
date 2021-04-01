import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2020-12-2020/12/14
 * Time: 18:31
 */
public class Test {
    public static void main(String[] args) {
    int[] arr={1,2,3,4,5,6};
    int[] copy=copyOf(arr);
    System.out.println(Arrays.toString(copy));
    }
    public static int[] copyOf(int[] arr) {
        int[] newarr=new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newarr[i]=arr[i];
        }
        return newarr;
    }
}
