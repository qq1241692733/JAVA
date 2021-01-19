package 常见的两个接口;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-01-2021/1/17
 * Time: 11:41
 */
class Student implements Comparable<Student>{
    public String name;
    public int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        return 0;
    }
}


public class TestDemo {
    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student("a", 89);
        students[0] = new Student("b", 80);
        students[0] = new Student("c", 68);
        System.out.println(Arrays.toString(students));
        System.out.println("============");
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }
}
