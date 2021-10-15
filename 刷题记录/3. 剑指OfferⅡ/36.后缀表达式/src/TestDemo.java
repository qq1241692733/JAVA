import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-10-2021/10/15
 * Time: 20:26
 */
public class TestDemo {
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"4","13","5","/","+"}));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int num1 = 0;
        int num2 = 0;
        while (i < tokens.length) {
            switch (tokens[i]) {
                case "+" :
                    stack.push(stack.pop() +
                            stack.pop());
                    break;
                case "*" :
                    stack.push(stack.pop() *
                            stack.pop());
                    break;
                case "-" :
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2 -
                            num1);
                    break;
                case "/" :
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2 /
                            num1);
                    break;
                default:
                    stack.push(Integer.valueOf(tokens[i]));
                    break;
            }
            i++;
        }
        return stack.peek();
    }
}
