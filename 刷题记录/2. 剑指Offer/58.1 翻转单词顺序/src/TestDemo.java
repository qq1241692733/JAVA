/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/3
 * Time: 17:27
 */
public class TestDemo {
    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println(reverseWords(s));
        System.out.println(reverseWords2(s));
    }
    public static String reverseWords(String s) {
        String[] split = s.split(" ");

        StringBuilder builder = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            // 由于split可能会产生空字符串 (连续多个空格)
            if (split[i].equals("")) continue;
            builder.append(split[i]).append(" ");
        }
        return String.valueOf(builder).trim();
    }
    public static String reverseWords2(String s) {
        s = s.trim();
        int right = s.length() - 1;
        int left = right;
        StringBuilder builder = new StringBuilder();
        while (left >= 0) {
            while (left >= 0 && s.charAt(left) != ' ') {
                left --;
            }
            builder.append(s.substring(left + 1, right + 1) + " ");
            while (left >= 0 && s.charAt(left) == ' ') {
                left --;
            }
            right = left;
        }
        return String.valueOf(builder).trim();
    }
}
