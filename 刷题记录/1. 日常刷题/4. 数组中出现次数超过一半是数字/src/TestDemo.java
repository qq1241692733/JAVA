import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
    找出数组中出现次数超过数组长一半的数字，如果没有就输出0
 * User: hong yaO
 * Date: 2021-04-2021/4/13
 * Time: 22:44
 */
public class TestDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,2,4,5,2,2};
        System.out.println(MoreThanHalfNum_Solution(arr));
    }
    public static int MoreThanHalfNum_Solution(int [] array) {
        int num = 0;
        int count = 0;
        int i = 0;
        while (i < array.length) {
            for (int tmp: array) {
                if (count == 0) {
                    num = tmp;
                }
                if (num == tmp) {
                    count ++;
                }else {
                    count --;
                }
            }
            i ++;
        }
        i = 0;
        count = 0;
        while (i < array.length) {
            if (array[i] == num) {
                count ++;
            }
            i ++;
        }
        if (count > array.length/2) {
            return num;
        }else return -1;
    }
}
