import java.util.Arrays;

public class V2 {
    public static void main(String[] args) {
        /*
        Bird b1 = new Bird(1,"small");
        b1.eat();
        b1.travel();
        b1.fly();
        System.out.println(Bird.isAnimal);

         */
        Size s1 = Size.valueOf("SMALL");
        //Indian i1 = new Indian("SMALL"); //错的
        Indian i1 = new Indian(s1);
        System.out.println(i1.gross);
        System.out.println(Arrays.toString(Size.values()));
        System.out.println(Size.SMALL.ordinal());  //0
    }
}
/*
抽象类 = 不能被实例化（A a = new A 不行）；其余与普通的类一样
 */
abstract class Humanbeing{
    public String name = "NiHeLu";
    private int age;

    public Humanbeing(){
        this.age = 1;
    }

    public void speak(){
        System.out.println("I'm human being");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //抽象方法：无方法体（{}的内容），因此抽象方法必须被子类重写
    public abstract void grow(int years);
}

class Indian extends Humanbeing{
    Size gross;

    public Indian(Size gross){
        super();
        this.gross = gross;
    }

    @Override
    public void grow(int years) {
        this.setAge(this.getAge() + years);
    }
}

/*
接口（Interface）:
1. 一种要求：子类拥有哪些功能
2.tag（类似Comparable）
无构造器
属性全部为 public static final
方法全部为 public abstract
 */
interface AnimalBehavior {  //实现接口用关键字 implements
    public static final boolean isAnimal = true;  //final:这个属性不能被修改

    public abstract void eat();
    public abstract void travel();
}

interface Flyable{
    public abstract void fly();
}

class Bird extends Animal implements AnimalBehavior, Flyable{

    public Bird(int age, String size) {
        super(age, size);
    }

    @Override
    public void eat() {
        System.out.println("eat");
    }

    @Override
    public void travel() {
        System.out.println("travel");
    }

    @Override
    public void fly() {
        System.out.println("fly");
    }
}

//枚举类：
/*
class Size {
    public static final Size SMALL = new Size();
    public static final Size MEDIUM = new Size();
    public static final Size BIG = new Size();

    public Size(){};
}
 */
enum Size{
    SMALL, MEDIUM, BIG;
}
// Size.valueOf(): 将一个字符串包装成Size的对象
// SMALL.values(): 获取Size中所有的值 [SMALL, MEDIUM, BIG]
// SMALL.ordinal():

