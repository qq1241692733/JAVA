/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GaoBo
 * Date: 2020-12-24
 * Time: 18:25
 */

class Person {
    public int age;
    public String name;//实例成员变量
    public static int count;//静态成员变量  类属性
    public int SIZE;
    //普通成员方法-》实例成员方法
    public void eat() {
        System.out.println(name+" 吃饭！");
    }
    //静态成员方法
    public static void func() {
        System.out.println(count);
        //System.out.println(age);
        System.out.println("静态方法func()");
    }

    /*public void show() {
        System.out.println("姓名："+name+" 年龄："+age);
    }*/
    @Override
    public String toString() {
        return "Person{" +
                "年龄=" + age +
                ", 姓名='" + name + '\'' +
                ", SIZE=" + SIZE +
                '}';
    }

}

public class TestDemo {

    public static void main(String[] args) {
        Person person1 = null;
        System.out.println(person1.age);
        /*Person person2 = new Person();
        person1 = person2;
        person1 = new Person();
        person1 = new Person();
        person1 = new Person();
        person1 = new Person();*/
    }

    public  static void main6(String[] args) {
        Person person1 = new Person();
        person1.name = "zhangsan";
        person1.age = 19;
        System.out.println(person1);
    }

    public static void main5(String[] args) {
        Person.count++;
        Person.count++;
        Person.count++;
        Person.func();
        System.out.println(Person.count);
    }

    public static void main4(String[] args) {
        Person person1 = new Person();
        person1.name = "zhangsan";
        person1.age = 19;
        person1.eat();

        Person person2 = new  Person();
        person2.name = "xiaoming";
        person2.age = 99;
        person2.eat();
    }
    public static void main3(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        Person person4 = new Person();

    }
    public static void main2(String[] args) {
        Person person = new Person();
        System.out.println(person.name);
        System.out.println(person.age);
        System.out.println(Person.count);
        System.out.println(person.count);
    }
    public static void main1(String[] args) {
        //实例化了一个对象
        Person person = new Person();
        //person引用
        System.out.println(person);
    }
}
