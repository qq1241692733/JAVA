import javafx.scene.transform.Scale;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
     对字符串中的所有单词进行倒排。说明:
         1、每个单词是以26个大写或小写英文字母构成;2、非构成单词的字符均视为单词间隔符;
         3、要求倒排后的单词间隔符以一个空格表示;如果原字符串中相邻单词间有多个间隔符时，倒排转换后也只允许出现一个空格间隔符;
         4、每个单词最长20个字母;
     示例：
         输入：I am a student
         输出：student a am I
 * User: hong yaO
 * Date: 2021-06-2021/6/9
 * Time: 23:30
 */
public class TestDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] arr = s.split("[^a-zA-Z]+");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = arr.length -1; i >= 0; i--) {
            stringBuilder.append(arr[i] + " ");
            //System.out.print(arr[i]+" ");
        }
        //System.out.print(arr[0]);
        System.out.println(stringBuilder.toString().trim());
    }
}
