/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-11-2021/11/13
 * Time: 17:38
 */
public class TestDemo {
    public boolean detectCapitalUse1(String word) {
        // 开头两字母小写大写  false, 长度 >= 2
        if (word.length() >= 2 && Character.isLowerCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) return false;

        // 后边的字母大小写与第二个字母不相同  false
        for (int i = 2; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i)) != Character.isUpperCase(word.charAt(1))) return false;
        }
        return true;
    }

    public boolean detectCapitalUse2(String word) {
        // 记录大写字母或者小写字母出现次数
        int count = 0, len = word.length();
        for (char ch : word.toCharArray()) {
            if (Character.isLowerCase(ch)) count ++;
        }
        // 小写字母出现次数：0、len、len-1且首字母大写
        return count == len || count == 0 ||
                (count == len - 1 && Character.isUpperCase(word.charAt(0)));
    }
}
