package 习题;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-01-2021/1/21
 * Time: 12:14
 */
class Student {
    public String name;
    public int age;
    public double score;

    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {

        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
public class TestDemo {
    public static void main(String[] args) {
    List<Student> list = new ArrayList<>();
    list.add(new Student("A", 6, 98));
    list.add(new Student("B", 19, 80));
    list.add(new Student("C", 20, 63));
    System.out.println(list);
    }
}
