import javax.print.DocFlavor;
import java.util.*;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * 从str1 中 删除 str2中包含的的字符
 如; 输入: "he  llo"    "ln"
 输出: he  o
 * User: hong yaO
 * Date: 2021-03-2021/3/1
 * Time: 13:37
 */
public class TestDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        List<Character> list1 = new LinkedList<>();
        List<Character> list2 = new LinkedList<>();
        int i = 0;
        for (char ch: str1.toCharArray()) {
            list1.add(ch);
        }
        i = 0;
        for (char ch: str2.toCharArray()) {
            list2.add(ch);
        }
        i = 0;
        for (i = 0; i < str2.length(); i++) {
            char ch = list2.get(i);
            while (list1.remove(Character.valueOf(ch))) ;
        }
        for (char ch: list1) {
            System.out.print(ch);
        }
    }
}
