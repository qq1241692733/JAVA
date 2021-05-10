import com.sun.xml.internal.ws.wsdl.writer.UsingAddressing;

import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-04-2021/4/19
 * Time: 16:47
 */
public class TestDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i:arr) {
              if (map.containsKey(i)) {
              int num = map.get(i);
              map.put(i,num +1);
          }else {
              map.put(i,1);
          }
        }
        int i = 0;
        int size = map.size();
        int[] arr1 = new int[2];
        for (Map.Entry<Integer,Integer> entry: map.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                arr1[i] = entry.getKey();
                i ++;
            }
        }
        System.out.println(Math.min(arr1[0],arr1[1]) + " " +Math.max(arr1[0],arr1[1]));
    }
}
