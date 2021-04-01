package com.baidu.www;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 文档注释 一般用于 方法的注释和类的注释
 * User: hong yaO
 * Date: 2021-01-2021/1/16
 * Time: 18:39
 */

class Animal {
    int val = 6;
    public String name;
    public int age;
    public void eat() {
        System.out.println(this.name+" : eat()");
    }

    public Animal() {
        System.out.println("Animal()");
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Animal(String name, int age)");
    }
}

class Bird extends Animal {
    public Bird() {
        System.out.println("Bird()");
    }

    public Bird(String name, int age) {
       super(name, age);
       System.out.println("Bird(String name, int age)");
    }

    public void eat() {
        System.out.println(this.name+" : eat()");
    }

    public void fly() {
        System.out.println(this.name + "bird: fly");
    }
}

class A{}
class B extends A{}
class C extends B{}

public class TestDemo {
    public static void main(String[] args) {
        A a0=new A();
        A a1=new B();
        A a2=new C();
    }

    public static void main3(String[] args) {
        Animal animal = new Animal();
        Bird bird = (Bird) animal;
    }

    public static void main2(String[] args) {
        Bird bird = new Bird();
        Animal animal = bird;
        animal.eat();
    }

    public static void main1(String[] args) {
    Bird bird = new Bird();
    bird.name = "麻雀";
    bird.eat();
    }
}