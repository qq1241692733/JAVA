import sun.security.krb5.internal.rcache.DflCache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-07-2021/7/30
 * Time: 18:45
 */
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}
public class TestDemo {
    public static void main(String[] args) {
        int a = 0;
    }

    public static int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee item: employees) {
            map.put(item.id, item);
        }
        return Dfs(map, id);
    }

    public static int Dfs(Map<Integer, Employee> info, int id) {
        int curImportance = info.get(id).importance;
        for (int subId : info.get(id).subordinates) {
            curImportance += Dfs(info, subId);
        }
        return curImportance;
    }
}
