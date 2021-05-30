import javafx.scene.transform.Scale;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-05-2021/5/28
 * Time: 0:32
 */
public class TestDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            float n = (float) sc.nextInt();
            NumberFormat percentFormat =NumberFormat.getPercentInstance();
            percentFormat.setMaximumFractionDigits(2); //最大小数位数
            percentFormat.setMaximumIntegerDigits(2);//最大整数位数
            percentFormat.setMinimumFractionDigits(2); //最小小数位数
            percentFormat.setMinimumIntegerDigits(2);//最小整数位数/
            System.out.println(percentFormat.format(1/n));
        }
    }
}
