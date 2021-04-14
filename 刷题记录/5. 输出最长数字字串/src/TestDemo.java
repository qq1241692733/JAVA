import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
        读入一个字符串str，输出字符串str中的连续最长的数字串
            输入： abcd12345ed125ss123456789
            输出： 123456789
    解题思路：遍历字符串，字符串拼接空格，数字直接拼接
            拼接结以空客分割放入数组，遍历最长字符串输出即可
 * User: hong yaO
 * Date: 2021-04-2021/4/13
 * Time: 23:14
 */
public class TestDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        int flag = -1;
        int count = 0;
        StringBuilder numStr = new StringBuilder();
        for (char ch :string.toCharArray()) {
            if (ch<= '9' & ch>= '0') {
                count ++;
                if (flag == 0){
                    numStr.append(" ");
                }
                if (flag == 1 | count == 1) {
                    numStr.append(ch);
                }
                flag = 1;
            }else {
                flag = 0;
                count = 0;
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
