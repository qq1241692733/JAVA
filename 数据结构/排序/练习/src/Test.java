import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-02-2021/2/2
 * Time: 16:06
 */

public class Test {
    public static void main1(String[] args) {
        int[] array = {10,3,2,7,19,78,65,127};
        System.out.println(Arrays.toString(array));
        TestDemo.quickSort(array);
        System.out.println(Arrays.toString(array));

    }

}
