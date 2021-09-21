/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-09-2021/9/21
 * Time: 12:09
 */
public class TestDemo {
    public static void main(String[] args) {

    }
    public String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int ai = a.length() - 1;
        int bi = b.length() - 1;
        int carry = 0;
        while (ai >= 0 || bi >= 0){
            int x = ai < 0 ? 0 : a.charAt(ai) - '0';
            int y = bi < 0 ? 0 : b.charAt(bi) - '0';
            int sum = x + y + carry;
            carry = sum / 2;
            builder.append(sum % 2);
            bi --;
            ai --;
        }
        if (carry == 1) builder.append(1);
        return String.valueOf(builder.reverse());
    }
}
