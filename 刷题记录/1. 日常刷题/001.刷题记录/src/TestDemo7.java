/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-11-2021/11/23
 * Time: 22:29
 */
public class TestDemo7 {
    public static void main(String[] args) {
        System.out.println(buddyStrings("aaa", "aaa"));
    }
    public static boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) return false;
        int idx = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i) && idx == -1) {
                idx = i;
            }else if (idx != -1) {
                if (chanceChar(s, idx, i).equals(goal)) {
                    return true;
                }else return false;
            }
        }

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a'] ++;
        }
        if (s.equals(goal) && s.length() >= 2) return true;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 2) {
                return true;
            }else return false;
        }
        return true;
    }
    public static String chanceChar(String s, int i, int j){
        StringBuilder builder = new StringBuilder(s);
        char a = s.charAt(i);
        builder.replace(i,i + 1, String.valueOf(s.charAt(j)));
        builder.replace(j,j + 1, String.valueOf(a));

        return String.valueOf(builder);
    }
}
