import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-05-2021/5/27
 * Time: 0:57
 */
public class TestDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            //*****************************
            scanner.nextLine();
            //*****************************
            String[] str = new String[n];
            for (int i = 0; i < n; i++) {
                str[i] = scanner.nextLine();
            }
            for (int i = 0; i < n; i++) {
                for (char ch : str[i].toCharArray()) {
                    if(ch == ',' || ch == ' ') {
                        str[i] ='"' + str[i] + '"';
                        break;
                    }
                }
            }
            for (int i = 0; i < str.length - 1; i++) {
                System.out.print(str[i] + ',');
            }
            System.out.println(str[str.length - 1]);
        }
    }

}
