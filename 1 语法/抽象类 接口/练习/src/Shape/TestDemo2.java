package Shape;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-01-2021/1/17
 * Time: 10:18
 */

abstract class Shape {
    public abstract void draw();
}
/**
 * 抽象类
 * 1、抽象类不能背实例化  Shape shape = new Shape()
 * 2、抽象类可以拥有数据成员和成员方法
 * 3、可以被继承
 * 4、普通类继承抽象类，普通类中一定要重写抽象类中的抽象方法
 * 5、抽象类继承抽象类，不需要重写方法
 * 6、抽象类不能用 private 修饰，因为抽象方法就是用来被继承的
 */
class Rect extends Shape {
    @Override

    public void draw() {
        System.out.println("♦");
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("⚪");
    }
}

abstract class A extends Shape {}
//class B extends A {}

public class TestDemo2 {

    public static void drawMap(Shape shape) {
        shape.draw();
    }

    public static void main(String[] args) {

    }
}
