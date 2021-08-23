/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-05-2021/5/20
 * Time: 23:41
 */
public class TestDemo {
    public static void main(String[] args) {
        System.out.println(replaceSpace("a b c"));
        System.out.println(replaceSpace1("a b c"));
        System.out.println(replaceSpace2("a b c"));
        System.out.println(replaceSpace3("a b c"));
        System.out.println(replaceSpace4("a b c"));
    }
    public static String replaceSpace(String s) {
        return s.replace(" ","%20");
    }
    public String replaceSpace10(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                stringBuilder.append("%20");
            }else {
                stringBuilder.append(s.charAt(i));
            }
        }
        return String.valueOf(stringBuilder);
    }
    public static String replaceSpace1(String s) {
        StringBuilder builder = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                builder.append("%20");
            }else {
                builder.append(ch);
            }
        }
        return builder.toString();
    }

    public static String replaceSpace2(String s) {
        String[] arr = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                arr[i] = "%20";
            }else {
                arr[i] = String.valueOf(s.charAt(i));
            }
        }
        StringBuilder builder = new StringBuilder();
        for (String string : arr) {
            builder.append(string);
        }
        return builder.toString();
    }

    public static String replaceSpace3(String s) {
        char[] arr = new char[3*s.length()];
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                arr[j++] = '%';
                arr[j++] = '2';
                arr[j++] = '0';
            }else {
                arr[j++] = s.charAt(i);
            }
        }
        return new String(arr,0,j);
    }

    public static String replaceSpace4(String s) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == ' ') count ++;
        }
        char[] arr = new char[count*2 + s.length()];
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                arr[j++] = '%';
                arr[j++] = '2';
                arr[j++] = '0';
            }else {
                arr[j++] = s.charAt(i);
            }
        }
        return new String(arr);
    }
}
