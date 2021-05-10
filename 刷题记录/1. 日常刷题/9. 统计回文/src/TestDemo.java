import java.lang.ref.SoftReference;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-04-2021/4/16
 * Time: 16:09
 */
public class TestDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String A = scanner.nextLine();
        String B = scanner.nextLine();
        int count=0;
        for (int i = 0; i < A.length()+1; i++) {
            String str = A.substring(0,i) +B +A.substring(i);
            if(isPalindrome(str)) count++;
        }
        System.out.println(count);
    }
    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) == str.charAt(right)) {
                left ++;
                right --;
            }else {
                return false;
            }
        }
        return true;
    }
}
