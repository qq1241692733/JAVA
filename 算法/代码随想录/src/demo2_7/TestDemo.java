package demo2_7;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2022-02-2022/2/7
 * Time: 20:28
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

class myCompare implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o2.compareTo(o1);
        //return o1.compareTo(o2);
        //return o2.age - o1.age;
    }
}
class MyCompare implements Comparator<Integer> {
    @Override
    public int compare(Integer x, Integer y) {
        return (x > y) ? -1 : ((x == y) ? 0 : 1);
    }
}
public class TestDemo {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("张三", 12, 70));
        list.add(new Student("李四", 18, 81));
        list.add(new Student("王五", 21, 93));
        System.out.println(list.toString());

//        list.sort(new myCompare());
//        list.sort(new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o2.age - o1.age;
//            }
//        });
//        list.sort((o1, o2) -> { return o1.age - o2.age;});
//        list.sort((o1, o2) -> o1.age - o2.age);
        Collections.sort(list);
        list.sort(null);
        System.out.println(list);

        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(1);
        list1.add(5);
        System.out.println(list1);
        //MyCompare myCompare = new MyCompare();
        //Collections.sort(list1, myCompare);
        Collections.sort(list1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        Collections.sort(list1, (Integer o1, Integer o2) -> {return o2 - o1; });
        Collections.sort(list1, (o2, o1) -> o2 - o1);
        list1.sort((o2, o1) -> o2 - o1);
        System.out.println(list1);


        Integer a = 0;
        System.out.println(a.compareTo(2));

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 5);
        map.put(2, 1);
        map.put(3, 7);


    }


}
