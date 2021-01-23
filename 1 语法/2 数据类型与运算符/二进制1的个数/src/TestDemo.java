import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:求一个整数，在内存当中存储时，二进制1的个数。
 * User: hong yaO
 * Date: 2020-12-2020/12/6
 * Time: 14:12
 */
public class TestDemo {
    public static void main(String[] args) {
        int count=0;
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        //0x110& 0x001=0
        //>> 0x11 &0x01=1
        //>> 0x1  &0x1=1
        //>> 0x0  退出循环
        while(num!=0) {
            if((num&1)==1) {
                count++;
            }
            num>>=1;
        }
        System.out.println(count);
    }
}
