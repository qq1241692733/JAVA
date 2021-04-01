import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import javax.sound.midi.Soundbank;

//包：同一个文件夹内
/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-01-2021/1/11
 * Time: 19:28
 */
class Animal {
    public String name;
    public int age;

//    {
//        System.out.println("父类实例代码块");
//    }
//    static {
//        System.out.println("父类静态代码块");
//    }

    public Animal() {
        System.out.println("Animal()");
    };

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Animal(String name, int age)");
    }

    public void eat() {
        System.out.println(this.name+" : eat()");
    }
}

class Dog1 {
    public String name;
    public int age;

    public void eat() {
        System.out.println("Dog eat()");
    }
}

/**继承
 * 义代码的复用
 * A extends B
 * A:基类/父类  B:子类/派生类
 * 子类继承父类的所有内容，除了构造方法；
 * 子类需要帮助父类构造
 * super代表父类对象的引用
*/
class Bird extends Animal {
//    {
//        System.out.println("子类实例代码块");
//    }
//    static {
//        System.out.println("子类静态代码块");
//    }
    public Bird () {
        super();
        System.out.println("Bird()");
    }
    public Bird (String name, int age) {
        super(name,age);
        System.out.println("super(name,age)");
    }
    public void fly() {
        System.out.println(this.name + "bird fly");
    }
}


/**
 * private   只能同一个包的同一个类才能才能访问
 * default   同一个包的不同类可以访问
 * protected 不同包的子类可以访问
 * public    不同包的非子类可以访问
 * 继承层数过多不易维护  不要超过3曾
 * final int a : 常量
 * final class : 密封类 代表当前类不可以被继承
 */
class A {}
class B extends A{}
class C extends B{}

final class D {}
//final class F extends D{}   报错

/**
 * 组合
 */

class Dog extends Animal {
    public int leg;
    public Dog () {
            super();
            System.out.println("Bird()");
            }
    public Dog (String name, int age) {
            super(name,age);
            System.out.println("super(name,age)");
            }
    public void eat() {
        System.out.println("Dog eat()");
    }
    public void wangwang() {
        System.out.println("汪汪");
    }
}

public class TestDemo {

    public static void main1(String[] args) {
    Bird bird1 = new Bird();
    System.out.println("=============");
    bird1.name = "麻雀";
    bird1.eat();
    }
/**
 * 多态
 * 向上转型: 父类的引用 引用子类对象
 * 1、直接转型
 * 2、方法传参
 * 3、方法的返回值
 */
    public static void main2(String[] args) {
        Animal animal = new Dog();   //向上转型
        animal.name = "哈士奇";
        animal.eat();
       // animal.wangwang();
       // animal.leg = 4;
    }
/**
 * 向下转型
 */
    public static void main3(String[] args) {
        Animal animal1 = new Dog();
        Dog dog = (Dog)animal1;
        dog.wangwang();

        Animal animal2 = new Dog();
        if (animal2 instanceof Bird) {
            Bird bird = (Bird)animal2;
            bird.fly();
        }
    }


}


