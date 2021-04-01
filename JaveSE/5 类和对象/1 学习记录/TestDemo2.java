/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GaoBo
 * Date: 2020-12-24
 * Time: 20:32
 */
class Student {

    //封装
    private String name1;
    private int age;
    public static int count=99;

    static {
        count = 10;
        //name1 = "gaobo";error
        System.out.println("静态代码块!");
    }

    {
        this.age = 10;
        this.name1 = "zhangsan";
        count = 99999;
        System.out.println("实例代码块！");
    }


    public Student() {
        //this("gaobo");
        //调用带有2个参数的构造方法
        // 必须放在第一行 且只能存在一构造方法内部
        //this("gaobo",18);
        System.out.println("调用了不带有参数的构造方法！");
    }

    public Student(String name1) {
        this.name1 = name1;
        System.out.println("调用了带有1个String参数的构造方法！");
    }

    public Student(String name1,int age) {
        this.age = age;
        this.name1 = name1;
        System.out.println("调用了带有2个String,int参数的构造方法！");
    }



    //只要你把属性或者方法设置为public 之后 那么我们就默认约定
    //将来这个东西 时不会发生改变的
    //alt+insert  或者鼠标右键 -》 gen.....
    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
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
                "name='" + name1 + '\'' +
                ", age=" + age +
                '}';
    }

    /**
     * 所有被private 所修饰的成员变量或者成员方法
     * 都只能在类内进行访问：
     */
    private void hahaha() {
        System.out.println("func()");
    }

    /**
     * 这个方法要是是静态的 那么就不能够用this啦~
     */
    public void func2() {
        this.hahaha();
        System.out.println(this.name1);
        System.out.println(this.age);
    }

}
public class TestDemo2 {

    public static void main(String[] args) {
        System.out.println(Student.count);
    }

    public static void main4(String[] args) {
        Student student = new Student();

        System.out.println("================");
        Student student2 = new Student();

    }

    public static void main7(String[] args) {
        int a = 10;
        {
            //本地代码块：定义在方法内部的代码块
            //int a = 20;
            System.out.println(a);
        }
        System.out.println(a);
    }

    public static void function(Student stu) {

    }
    public static void main6(String[] args) {

        function(new Student());

        Student student = new Student();
        function(student);
    }

    public static void main5(String[] args) {
        new Student().func2();//匿名对象
        new Student().func2();

        Student student = new Student();
        student.func2();
        student.func2();
    }

    public static void main3(String[] args) {
        Student student = new Student();
        System.out.println(student);
    }

    public static void main2(String[] args) {

        Student student = new Student();
        System.out.println(student);
        System.out.println("==================");

        Student student2 = new Student("gaobo");
        System.out.println(student2);
        System.out.println("==================");

        Student student3 = new Student("lisi",88);
        System.out.println(student3);
    }

    public static void main1(String[] args) {
        Student student = new Student();
        //student.name = "zhangsan";
        //student.age = 10;
        student.setName1("zhangsan");
        System.out.println(student.getName1());
        System.out.println(student);
        student.func2();
    }

}
