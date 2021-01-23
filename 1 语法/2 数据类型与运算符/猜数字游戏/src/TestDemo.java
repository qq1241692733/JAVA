import java.util.Random;
import java.util.Scanner;

public class TestDemo {
    public static void main(String[] args) {
        //完成猜数字游戏 ，用户输入数字，判断该数字是大于，小于，
        // 还是等于随机生成的数字，等于的时候退出程序。

        Scanner scanner=new Scanner(System.in);
        Random random=new Random();
        int randNum=random.nextInt(100)+1;  //[1,100)
        while(true) {
            int num=scanner.nextInt();
            if(num<randNum) {
                System.out.println("猜小了");
                }
                    else if(num>randNum) {
                        System.out.println("猜大了");
                    }
                        else {
                            System.out.println("猜对了");
                            break;
                        }
        }
    }
}
