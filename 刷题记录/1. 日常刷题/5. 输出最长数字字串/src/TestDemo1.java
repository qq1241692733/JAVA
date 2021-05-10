import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-04-2021/4/14
 * Time: 0:59
 * 改进后
 */
public class TestDemo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        StringBuilder numStr = new StringBuilder();
        for (char ch :string.toCharArray()) {
            if (ch<= '9' & ch>= '0') {
                numStr.append(ch);
            }else {
                numStr.append(" ");
            }
        }
        String[] ret = numStr.toString().split(" ");
        int maxLen = 0;
        int index = 0;
        for (int i = 0; i < ret.length; i++) {
            if (maxLen < ret[i].length()) {
                maxLen = ret[i].length();
                index = i;
            }
        }
        System.out.println(ret[index]);
    }
}
