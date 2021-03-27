/**
 * Created with IntelliJ IDEA.
 * Description:
 * 写一个递归方法，输入一个非负整数，返回组成它的数字之和
 * User: hong yaO
 * Date: 2021-01-2021/1/4
 * Time: 23:00
 */
public class TestDemo {
    public static void main(String[] args) {
        System.out.println(numSum(1234));
    }
    public static int numSum(int num) {
        if (num < 10){
            return num;
        }
        return num % 10 + numSum(num / 10);
    }
}
