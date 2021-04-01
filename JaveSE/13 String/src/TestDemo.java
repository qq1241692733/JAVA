/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-01-2021/1/20
 * Time: 9:05
 */
public class TestDemo {
    /**
     * String 和StringBuilder  StringBuffer区别
     * 1、后者有一些String没有的方法；
     * 2、String 是不可变的
     * @param args
     * StringBuilder 和 StringBuffer 区别
     * StringBuilder 有 synchronized修饰，保证线程的安全操作
     * 一般出现在多线程情况下，会消耗资源。
     *
     * String 和 StringBuilder 区别：
     * 1、String的+拼接会被优化为StringBuilder 的 append，在循环拼接时每次进入循环都会new新对象，会产生大量临时对象,
     * 1、在循环中 不可以String的拼接会产生临时对象,
     */
    public static void main7(String[] args) {
        String str = "hello";

        StringBuilder sb = new StringBuilder("hello");
        System.out.println(sb.reverse());
        System.out.println(sb.append("worrd")); //拼接
    }

    public static void main(String[] args) {
//        String str = "abc";
//        for (int i = 0; i < 1000; i++) {
//            str += 1;
//        }
//        System.out.println(str);
        String str = "abc";
        for (int i = 0; i < 1000; i++) {
            str += 1;
        }
        System.out.println(str);

    }

    /**
     * 其他操作
     */
    public static void main6(String[] args) {
        String string = "abcdefg";
        System.out.println(string.trim());
    }

    /**
     *字符串截取 substring();
     */
    public static void main5(String[] args) {
        String string = "abcde";
        System.out.println(string.substring(3));
        System.out.println(string.substring(0,3));
    }

    /**
     * 切割
     */
    public static void main4(String[] args) {

        String str1 = "name&666";
        String[] strings = str1.split("&", 2);
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
        System.out.println("************");
        String str2 = "192.168.101.101";
        String[] string = str2.split("\\.");
        for (int i = 0; i < string.length; i++) {
            System.out.println(string[i]);
        }
    }

    /**
     *替换 replaceAll(); replaceFirst(); replace();
     */
    public static void main3(String[] args) {
        String str1 = "abcdefg";
        System.out.println(str1.replaceAll("a", "aaa"));
        System.out.println(str1.replaceFirst("f","6"));
        System.out.println(str1.replace("a", "6"));
    }

    /**
     * 字符串的查找 contains(); indexOf(); lastIndexOf(); startsWith(); endsWith();
     */
    public static void main2(String[] args) {
        String str1 = "abcdefg";
        System.out.println(str1.contains("abc"));

        System.out.println(str1.indexOf("de"));
        System.out.println(str1.indexOf("de",4));

        System.out.println(str1.lastIndexOf("bc"));

        System.out.println(str1.startsWith("a"));
        System.out.println(str1.startsWith("c",2));

        System.out.println(str1.endsWith("f"));  //一个参数
    }

    /**
     * 字符串的比较 compareTo(); equals(); equalsIgnoreCase();
     */
    public static void main1(String[] args) {
        String str1 = "abc";
        String str2 = "Abc";
        String str3 = new String("abc");

        System.out.println(str1.compareTo(str2));
        System.out.println(str1.equals(str2));
        System.out.println(str1.equalsIgnoreCase(str2));
    }
}
