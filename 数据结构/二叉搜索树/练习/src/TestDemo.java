import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;
import netscape.security.UserTarget;

import javax.jws.Oneway;
import javax.management.relation.RelationNotFoundException;
import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-02-2021/2/8
 * Time: 16:09
 */
public class TestDemo {
    public static void main(String[] args) {
       // System.out.println(findFirstRepeatNumber());
       // System.out.println(deputil());
        func();
    }

    /**
     *统计10w个数据中重复出现的数字次数
     */
    public static void func() {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(10));
        }
        System.out.println(list);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            if (map.get(list.get(i)) == null) {
                map.put(list.get(i), 1);
            }else {
                map.put(list.get(i), map.get(list.get(i)) + 1);
            }
        }

//        for (int i = 0; i  < list.size(); i++) {
//            if (map.get(list.get(i)) > 1) {
//                System.out.println(list.get(i) + " " + map.get(list.get(i)));
//            }
//        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }
    /**
     *找出10W个数据中，第一个重复的数据
     *  思路： 遍历List拿到每一个元素存到 set，储存之前看set中是否又这个数据，
     *  有就说明找到了
     */
    public static int findFirstRepeatNumber() {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10_0000; i++) {
            list.add(random.nextInt(1_0000));
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 10_0000; i++) {
            if (set.contains(list.get(i))) {
                return list.get(i);
            }else {
                set.add(list.get(i));
            }
        }
        return -1;
    }

    /**
     * 10W个数据去重
     */
    public static Set<Integer> deputil() {
        Random random;
        random = new Random();
        ArrayList<Integer> list= new ArrayList<>();
        for (int i = 0; i < 10_0000; i++) {
            list.add(random.nextInt(1_0000));
        }
        HashSet<Integer> set = new HashSet<>();
         for (int i = 0; i < 10_0000; i++) {
            set.add(list.get(i));
        }
        return set;
    }
    /**
     *Set中不能存储相同的元素,Set中只存储了Key
     */
    public static void main2(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(10);
        set.add(20);
        set.add(1);
        set.add(45);
        set.add(10);
        set.add(null);
        System.out.println(set);
        System.out.println(set.size());
    }
    public static void main1(String[] args) {
        // HashMap <key, val>
        HashMap<String, Integer> hashMap = new HashMap<> ();
        Map<String, String> map = new HashMap<> ();
        map.put("a", "A");
        map.put("b", "B");
        map.put("c", "A");
        map.put("b", "BB");
        map.put(null, null);
        map.put(null, null);
        System.out.println(map);
        String val = map.get("a"); //拿到key:a 对应的val值
        System.out.println(val);

        Set<String> set = map.keySet();
        System.out.println(set);

        Set<Map.Entry<String, String>> set1 = map.entrySet();
        System.out.println(set1);
        for (Map.Entry<String, String> entry : set1) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
