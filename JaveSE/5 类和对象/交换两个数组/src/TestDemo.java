import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2020-12-2020/12/31
 * Time: 17:54
 */
public class TestDemo {

    public static void main(String[] args) {
        int[] arr1={1,2,3,4,5,6,7,8};
        int[] arr2={8,7,6,5,4,3,2,1};
        System.out.println("交换前：");
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        exchangeArr(arr1,arr2);
        System.out.println("交换后：");
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
    public static void exchangeArr(int[] arr1,int[] arr2) {
        for (int i = 0; i < arr1.length ; i++) {
            int temp = arr1[i];
            arr1[i] = arr2[i];
            arr2[i] = temp;
        }
    }
}
