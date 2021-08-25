/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-08-2021/8/26
 * Time: 0:28
 */
public class TestDemo {
    public static void main(String[] args) {

    }
    // 二分
    public static int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int min = (left + right) / 2;
            if (numbers[min] < numbers[right]) {
                right = min;
            }else if (numbers[min] > numbers[right]){
                left = min + 1;
            }else {
                right --;
            }
        }
        return numbers[left];
    }

    // 暴力
    public static int minArray1(int[] numbers) {
        int index = 1;
        while (index < numbers.length) {
            if (numbers[index] > numbers[index - 1]) {
                index ++;
            }else {
                return numbers[index];
            }
        }
        return numbers[0];
    }
}
