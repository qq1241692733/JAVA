import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-06-2021/6/6
 * Time: 16:29
 */
public class TestDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder();
        for(char ch : str.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                stringBuilder.append(ch);
            }
        }
        System.out.println(stringBuilder);
    }
}
