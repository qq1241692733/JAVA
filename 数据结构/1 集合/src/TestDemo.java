import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-01-2021/1/20
 * Time: 11:46
 */

class
MyArrayList {
    public int[] elem;
    public int usedSize;
}
public class TestDemo {
    public static void main1(String[] args) {
        Collection collection = new ArrayList();
        collection.add(1);
        collection.add("a");
        System.out.println(collection);
    }

    public static void main(String[] args) {
        Map<String ,String> map = new HashMap<>();
        map.put("玄奘", "唐僧");
        map.put("女神", "乔碧萝");
        map.put("男神", "蔡徐坤");
        System.out.println(map.get("男神"));
        System.out.println(map);
    }
}
