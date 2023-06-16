import java.util.*;

public class V6 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("sss");
        list.add("hahaha");
        list.add("rarara");
        list.add("sss");
        System.out.println(list);
        /*
        System.out.println(list.size());
        list.add("qqq");
        System.out.println(list.size());
        System.out.println(list.get(3));
        System.out.println(list.contains("hahaha"));
        System.out.println(list.indexOf("hahaha"));
        list.set(2, "haha");
        System.out.println(list);
        System.out.println(list.subList(1, 3));

         */

        /*
        ArrayList<Person> list = new ArrayList<Person>();
        Student s = new Student();
        Teacher t = new Teacher();
        list.add(s);
        list.add(t);
        System.out.println(list);

         */

        HashSet<String> set = new HashSet<>();
        set.add("aaa");
        set.add("bbb");
        set.add("ccc");
        set.add("aaa");
        System.out.println(set);

        HashMap<String, Integer> domains = new HashMap<>();
        domains.put("runoob.com", 123456);
        domains.put("google.com", 142857);
        domains.put("javadoc.com", 999999);
        domains.put("lmu.de", 666666);
        System.out.println(domains);
        System.out.println(domains.get("runoob.com"));

        for(String name : domains.keySet()){
            System.out.println(domains.get(name));
        }
    }
}

class Person{}

class Student extends Person{
    @Override
    public String toString() {
        return "zu viele Hausaufgabe";
    }
}

class Teacher extends Person{
    @Override
    public String toString() {
        return "zu wenige Hausaufgabe";
    }
}
