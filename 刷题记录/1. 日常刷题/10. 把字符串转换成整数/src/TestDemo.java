import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-04-2021/4/16
 * Time: 21:34
 */
public class TestDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        System.out.println(StrToInt(string));
    }
    public static int StrToInt(String str) {
        // j:符号位
        int j = 1;
        int i = 0;

        if (str.charAt(0) == '+') {
            i = 1;
            j = 1;
        }else if (str.charAt(0) == '-') {
            i = 1;
            j = -1;
        }

        int sum = 0;
        for (; i < str.length() ; i++) {
            int num = str.charAt(i) - '0';
            if (num >=0 && num <=9) {
                sum = sum *10 + num;
            }else return 0;
        }
        return sum*j;
    }
}
