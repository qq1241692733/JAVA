package demo1;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-01-2021/1/17
 * Time: 9:24
 */

class Shape {
    public void draw() {
    }
}

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

public class TestDemo {
    public static void main(String[] args) {
        Rect rect = new Rect();
        drawMap(rect);

        Circle circle = new Circle();
        drawMap(circle);
    }

    public static void drawMap(Shape shape) {
        shape.draw();
    }
}
