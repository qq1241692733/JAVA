/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2020-12-2020/12/30
 * Time: 11:50
 */
class Person {
    public int age;
    public String name;  //实例成员变量
    public static int count;  //静态成员变量
    public int SIZE;
    public final int COUNT = 66;
    public void eat() {
        System.out.println(name+"吃饭");
    }

    public static void func() {
        System.out.println(count);
        System.out.println("静态方法func（）");
    }

    @Override   //重写
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", SIZE=" + SIZE +
                '}';
    }
}
public class TestDemo {
    //类外初始化
    public static void main(String[] args) {
        Person.func();
        Person person1= new Person();
        System.out.println(person1);
        person1.name = "jhy";
        person1.age = 20;
        person1.eat();
    }

    public static void main1(String[] args) {
        //默认初始化
        Person person1 = new Person();      //实例化对象
        System.out.println(person1);         //地址的哈希值  类名是引用
        System.out.println(person1.name);    // null
        System.out.println(person1.age);     //实例成员变量通过对象的引用来访问
        System.out.println(Person.count);   //静态成员变量用类名访问，使用对象的引用访问不合理单合法

    }

}
