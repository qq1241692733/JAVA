package demo2_8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2022-02-2022/2/8
 * Time: 11:33
 */
class Student implements Comparable<Student>{
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
    @Override
    public int compareTo(Student o) {
        return this.age - o.age;
    }
}
public class TestDemo {
    public static void main(String[] args) {

        List<Student> list = new ArrayList<>();
        list.add(new Student("张三", 12, 70));
        list.add(new Student("李四", 21, 81));
        list.add(new Student("王五", 18, 93));
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list, (o1, o2) -> (int) (o2.score - o1.score));
        System.out.println(list);
    }
}
