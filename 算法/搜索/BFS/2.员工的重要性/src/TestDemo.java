import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-08-2021/8/3
 * Time: 19:29
 */
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};

public class TestDemo {
    public static void main(String[] args) {

    }

    /**
     * 深度优先搜索
     */
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for(Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return dfs(map,id);
    }
    public static int dfs(Map<Integer, Employee> map,  int id) {
        int curImportance = map.get(id).importance;
        for(int subId : map.get(id).subordinates) {
            curImportance += dfs(map, subId);
        }
        return curImportance;
    }

    /**
     * 广度优先搜索
     */
    public int getImportance1(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for(Employee employee : employees) {
            map.put(employee.id, employee);
        }
        int curImportance = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);
        while (!queue.isEmpty()) {
            int curId = queue.poll();
            curImportance += map.get(curId).importance;
            List<Integer> subordinates = map.get(curId).subordinates;
            for(int subId : subordinates) {
                queue.offer(subId);
            }
        }
        return curImportance;
    }
}
