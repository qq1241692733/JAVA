import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
   输入： hello_world
         nice_to_meet_you
   输出： helloWorld
         niceToMeetYou
 * User: hong yaO
 * Date: 2021-06-2021/6/9
 * Time: 18:43
 */
public class TestDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string = scanner.nextLine();
            int flag = 0;
            StringBuilder stringBuilder = new StringBuilder(0);
            for(char ch : string.toCharArray()) {
                if (ch != '_') {
                    if (flag == 0) {
                        stringBuilder.append(ch);
                    }else {
                        stringBuilder.append((char) (ch-32));
                        flag = 0;
                    }
                }else {
                    flag = 1;
                }
            }
            System.out.println(stringBuilder);
        }
    }
}
