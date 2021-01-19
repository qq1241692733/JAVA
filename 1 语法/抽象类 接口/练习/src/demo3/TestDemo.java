package demo3;

//import Shape.Shape;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-01-2021/1/17
 * Time: 10:45
 */

interface IShape {
    int age = 10;
    void draw();

    default void func() {}
}
/**
 * 接口：关键字interface修饰
 * 1、接口不能实例化
 *    接口中的方法不能又具体的实现，
 * 2、接口中的 方法 默认是 public abstract
 *   成员变量 默认是 public static final
 * 2、JDK1.8引入新特性，default修饰方法可以又棘突的实现
 * 3、类和接口的关系 implements
 * 4、一个类可以实现多个接口
 * 6、
 * 5、接口可以扩展多个接口，解决多继承问题
 */
class Rect implements IShape {
    @Override
    public void draw() {
        System.out.println("♦");
    }
}

class Circle implements IShape {
    @Override
    public void draw() {
        System.out.println("⚪");
    }
}

public class TestDemo {
    public static void drawMap(IShape shape) {
        shape.draw();
    }
    public static void main(String[] args) {
        IShape shape = new Rect();
        drawMap(shape);
    }
}
