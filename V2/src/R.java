public class R {
    public static void main(String[] args) {
        Animal z8 = new Animal(4,"small");
        System.out.println(z8.getAge() + " " + z8.size);
        z8.size = "big";
        System.out.println(z8.getAge() + " " + z8.size);
        z8.setAge(8);
        System.out.println(z8.getAge() + " " + z8.size);
        Dog b9 = new Dog(6,"medium", "xiaogou");
        b9.speak();
        Person ooo = new Person("zzz");
        ooo.adoptcat(b9);
        System.out.println(ooo.numberofpet);
        ooo.speak();  //类的对象可以调用static方法
        Person.speak();  //类可以调用static方法
    }
}

class Animal {
    private int age;
    public String size;

    public Animal(int age,String size){
        this.age = age;
        this.size = size;
    }

    public void setAge(int a1){
        this.age = a1;
    }

    public int getAge(){
        return this.age;
    }
}

class Dog extends Animal {
    public String name = "xiaogou";
    public boolean isPet = false;

    public Dog(int age, String size, String name){
        super(age, size);
        this.name = name;
    }

    public void speak(){
        System.out.println("wangwang");
    }
}

class Person {
    public String name;
    public int numberofpet = 0;

    public Person(String name){
        this.name = name;
    }

    public void adoptcat(Dog aaa){
        aaa.isPet = true;
        this.numberofpet += 1;
    }

    public static void speak(){
        //static方法只能操作static属性
        System.out.println("I'm a human being");
    }
}
