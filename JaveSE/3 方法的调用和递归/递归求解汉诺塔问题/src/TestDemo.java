import java.util.Scanner;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-01-2021/1/4
 * Time: 22:49
 */
public class TestDemo {
    public static void main(String[] args) {
        hanota(3,'A','B','C');
    }
    public static void move(char pos1,char pos2) {
        System.out.print(pos1+"->"+pos2+" ");
    }
    public static void hanota(int n,char pos1, char pos2,char pos3) {
        if(n == 1) {
            move(pos1,pos3);
            return;
        }
        hanota(n-1,pos1,pos3,pos2);
        move(pos1,pos3);
        hanota(n-1,pos2,pos1,pos3);
    }
}
