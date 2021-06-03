import java.util.Scanner;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-06-2021/6/3
 * Time: 20:09
 */
public class TestDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            Stack<String> stack = new Stack<>();
            for (int i = 0; i < n; i++) {
                String s = scanner.next();
                switch (s) {
                    case "+":
                        stack.add(String.valueOf(Integer.parseInt(stack.pop()) + Integer.parseInt(stack.pop())));
                        break;
                    case "-":
                        stack.add(String.valueOf(Integer.parseInt(stack.pop()) - Integer.parseInt(stack.pop())));
                        break;
                    case "*":
                        stack.add(String.valueOf(Integer.parseInt(stack.pop()) * Integer.parseInt(stack.pop())));
                        break;
                    case "/":
                        stack.add(String.valueOf(Integer.parseInt(stack.pop()) / Integer.parseInt(stack.pop())));
                        break;
                    default:
                        stack.add(s);
                        break;
                }
            }
            System.out.println(stack.peek());
        }
    }
}
