/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2020-12-2020/12/31
 * Time: 13:19
 */
class Student {
    private String name;
    private int age;
/**
 * 所有被private修饰的成员变量和成员方法都只能在类类进行访问
 * */
    public Student() {
        this("jhy");  //必须放在第一行
        System.out.println("调用了不带参数的构造方法");
    }

    public Student(String name) {
        this.name = name;
        System.out.println("调用了带有一个String参数的构造方法");
    }
    /** ALT+Insert或者右键Generate(产生)
    *
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}


public class TestDemo2 {
    public static void main3(String[] args) {
        Student student = new Student("张三");
       // student.setName("张三");
        student.setAge(20);
        System.out.println(student);
        Student student1 = new Student();
        System.out.println(student1);
    }

    public static void func(Student stu) {

    }

    public static void main1(String[] args) {
        func(new Student());

        Student stu = new Student();
        func(stu);
    }


}
