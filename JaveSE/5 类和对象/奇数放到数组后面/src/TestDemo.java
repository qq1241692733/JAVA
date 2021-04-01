import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 给定整型数组, 把所有的偶数放到数组前面, 把所有奇数放到数组后面.
 * User: hong yaO
 * Date: 2020-12-2020/12/31
 * Time: 17:29
 */
public class TestDemo {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6,7,8};
        System.out.println(Arrays.toString(arr1));
        int j=0;
        for (int i = 1; i <arr1.length; i++) {
            if(arr1[i]%2==0) {
                int temp =arr1[i];
                arr1[i]=arr1[j];
                arr1[j]=temp;
                j++;
            }
        }
        System.out.println(Arrays.toString(arr1));
    }
}
