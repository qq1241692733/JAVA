/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-11-2021/11/17
 * Time: 19:01
 */
public class TestDemo2 {
    public static void main(String[] args) {

    }
    public int maxProduct(String[] words) {
        int maxPor = 0;
        int[] nums = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            nums[i] = convert(words[i]);
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                // 判断两单词是否有重复字母，只需要看两个单词对应的二进制数字相与 是否为0
                if ((nums[i] & nums[j]) == 0)  {
                    maxPor = Math.max(maxPor, words[i].length() * words[j].length());
                }
            }
        }
        return maxPor;
    }

    /**
     * 单词转为 长度位26的 int数
     *  'a':   1 = 1<<0
     *  'b':  10 = 1<<1
     *  'c': 100 = 1<<2
     * 'abc': 111 = 1 | 10 | 100
     */
    public int convert(String world) {
        int res = 0;
        for (int i = 0; i < world.length(); i++) {
            res |= 1 << (world.charAt(i) - 'a');
        }
        return res;
    }
}
