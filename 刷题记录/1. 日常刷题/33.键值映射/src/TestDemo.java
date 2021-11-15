import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-11-2021/11/14
 * Time: 15:45
 */
class MapSum1 {
    HashMap<String, Integer> map = null;
    public MapSum1() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        int delta = val;
        map.put(key, val);
        for (int i = 1; i <= key.length(); i++) {
            map.put(key.substring(0,i), map.getOrDefault(key, 0) + delta);
        }
    }

    public int sum(String prefix) {
        return map.getOrDefault(prefix, 0);
    }
}
class MapSum {
    HashMap<String, Integer> map = null;
    public MapSum() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int res = 0;
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            if (entry.getKey().startsWith(prefix))
//                res += entry.getValue();
//        }
        for (String s : map.keySet()) {
            if (s.startsWith(prefix))
                res += map.get(s);
        }
        return res;
    }
}
public class TestDemo {
    public static void main(String[] args) {
        MapSum1 mapSum1 = new MapSum1();
        mapSum1.insert("apple", 3);
        System.out.println(mapSum1.sum("ap"));
        mapSum1.insert("app", 2);
        System.out.println(mapSum1.sum("ap"));
        mapSum1.insert("apple", 2);
        System.out.println(mapSum1.sum("ap"));
    }
}
