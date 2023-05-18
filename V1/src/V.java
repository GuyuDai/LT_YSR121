//面向对象(Object Orientiert)
public class V {    //大括号{}:定义域
    public static void main(String[] args) {
        /*
        Person p1 = new Person("Mike");
        Person p2 = new Student();
        Person p3 = new Person("Rose");
        //System.out.println(p1.id);
        //System.out.println(p1.getAge());
        p1.speak();
        //System.out.println(p1.getAge());
        p2.speak();
        //p3.speak(1);
        int var = p3.speak(1);
        //System.out.println(var);
        System.out.println(p2.id);
        System.out.println(p2.count);
        //System.out.println(p3.id);
        //System.out.println(p3.count);
        Person p4 = new Person("Karl");
        System.out.println(p4.getAge());  //0
        p4.grow();
        System.out.println(p4.getAge());  //1
        System.out.println(p4.name + "'s age is " + p4.grow(4)); //5
        System.out.println(p4.name + " next year will be " + (p4.grow(4)+1));  //10
        System.out.println(p4.getAge());  //9

         */

        Person ps = new Person();
        Person pp1 = new Student();
        Person t1 = new Teacher();
        //pp1.speak();
        //t1.speak();
        //t1.speak("Teacher");
        ps.shuohua();
        pp1.shuohua();
        t1.shuohua();

        /*
        Student s1 = (Student) pp1;
        System.out.println(s1.name);
        System.out.println(s1.student_id);
        s1.speak();
        System.out.println(s1.getAge());

         */
    }
}

/*
类(Class):对一系列具有类似属性、方法的对象的抽象
对象(Object):是一个类具体的一个实现
Class-Object:是一对儿概念
 */
class Person{  //Person是一个类
    //属性的定义方式:可见度 数据类型 属性名 (= 默认值);
    private int age;    //Attribute(属性) -> private:可见度; int:属性的数据类型; age:属性名
    public String name = "Hans";  // -> = "Hans":属性的默认值(自定义的)
    public String augenfarbe = "Black";
    /*
    系统定义的属性默认值: 数字 -> 0/0.0; boolean: 0(false); String和一切引用数据类型（类）: null(空)
     */
    public boolean isMale;
    public int id;
    static public int count;  //static: 静态/共享
    /*
    可见度(从大到小): public，不写，protected，private
    default (即默认，什么也不写）: 在同一包内可见，不使用任何修饰符。使用对象：类、接口、变量、方法。
    private : 在同一类内可见。使用对象：变量、方法。 注意：不能修饰类（外部类）
    public : 对所有类可见。使用对象：类、接口、变量、方法
    protected : 对同一包内的类和所有子类可见。使用对象：变量、方法。 注意：不能修饰类（外部类）。
     */
    /*
    Constructor(构造器):一个方法，专门用来创造对象的
    可见度 方法名（必须与类名一致） （传入值）{}
     */

    public Person(){
        this.augenfarbe = "Red";
        this.id = count;
        count += 1;  // id = id + 1
    }
    public Person(String name){  //方法同名不同参:重写 (对比重构)
        this.name = name;  //this表示调用这个方法的对象
        this.id = count;
        count += 1;
    }

    //方法的定义：可见度 回传值 方法名（传入值）{}
    public void speak(){
        this.setAge(3);
        System.out.println("I'm " + this.name);
    }

    public void speak(String words){
        this.setAge(3);
        System.out.println(this.name + ": " + words);
    }

    public int speak(int x){
        this.speak();
        return x + 1;
    }

    public void shuohua(){
        if(this.getClass() == Student.class){
            System.out.println("zu viele Hausaufgabe");
        } else if (this.getClass() == Teacher.class) {
            System.out.println("zu wenig Hausaufgabe");
        }else {
            this.speak();
        }
    }

    public void grow(){
        this.age += 1;
        System.out.println(this.name + ": " + this.age);
    }

    public int grow(int x){
        this.age += x;
        return this.age;
    }

    /*
    Getter/Setter
     */

    public void setAge(int x) {
        this.age = x;
    }

    public int getAge() {
        return this.age;
    }
}

//继承(extend)
class Student extends Person{
    public int student_id = 1000;  //独属于子类的属性
    public Student(){  //必须有的：构造器 -> 子类的构造器都默认在第一行调用了 super（） -> super = 父类的空参构造器
        this.setAge(6);
        this.augenfarbe = "Blue";
        this.student_id = 1000 + count;
    }

    @Override  //方法的重构: 方法同名同参但一个属于父类，一个属于子类，子类重构父类方法
    public void speak() {
        System.out.println("I'm a student");
    }
}

class Teacher extends Person{
    public Teacher(){}

    @Override
    public void speak() {
        System.out.println("I'm a teacher");
    }
}

/*
基本数据类型 -> 引用数据类型
int -> Integer
double -> Double
boolean -> Boolean
...
 */