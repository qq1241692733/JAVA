import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 实现一个方法 transform, 以数组为参数, 循环将数组中的每个元素 乘以 2 ,
 并设置到对应的数组元素上. 例如 原数组为 {1, 2, 3}, 修改之后为 {2, 4, 6}
 * User: hong yaO
 * Date: 2020-12-2020/12/13
 * Time: 12:47
 */
public class Test {
    public static void main(String[] args) {
        int[] arr={1,2,3};
        transform(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void transform(int[] arr) {
        for(int i=0;i<arr.length;i++) {
            arr[i]=2*arr[i];
        }
    }
}
