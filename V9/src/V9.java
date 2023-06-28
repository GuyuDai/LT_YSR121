import java.util.ArrayList;

public class V9 {
    public static void main(String[] args) {
        //Test1 t = new Test1();
        //t.m1();
        //Test3 t3 = new Test3();
        //t3.m3();
        Test4 t4 = new Test4();
        t4.m5();
    }


}

class Test1{

    /*
    try{
        可能存在问题的代码
    }catch(可能产生的问题1 e1){
        处理问题
        // 通常使用 e1.getMessage();
    }catch(可能产生的问题2 e2){
        处理问题
    } ......
     */
    public void m1(){
        String[] ints = {"1","2","3","hello"};
        try {
            System.out.println(Integer.parseInt(ints[0]));  //正确代码正常执行
            System.out.println(Integer.parseInt(ints[1]));  //正确代码正常执行
            //System.out.println(Integer.parseInt(ints[4]));  //有问题的代码(e1)
            System.out.println(Integer.parseInt(ints[2]));  //不会执行
            //System.out.println(Integer.parseInt(ints[3]));  //不会执行  //有问题的代码(e2)
            System.out.println("very important code");
        }catch (ArrayIndexOutOfBoundsException e1){
            System.out.println("first catch block");
            System.out.println(e1.getMessage());
        }catch (NumberFormatException e2){
            System.out.println("second catch block");
            System.out.println(e2.getMessage());
        }finally {  // 不管发生什么错误最终都必须执行的代码
            System.out.println("very important code");
            //有哪些code very importanArrayIndexOutOfBoundsExceptiont: scanner.close()
        }
        System.out.println("fortschreiten");
    }
}

class Test2{

    public void m2() throws RuntimeException{  //throws: 将Exceptions搁置,等到调用m2时再处理 (集中处理)
        String[] ints = {"1","2","3","hello"};
        System.out.println(Integer.parseInt(ints[0]));  //正确代码正常执行
        System.out.println(Integer.parseInt(ints[1]));  //正确代码正常执行
        System.out.println(Integer.parseInt(ints[4]));  //有问题的代码(e1)
        System.out.println(Integer.parseInt(ints[2]));  //不会执行
        System.out.println(Integer.parseInt(ints[3]));  //不会执行  //有问题的代码(e2)
        System.out.println("very important code");
    }
}

class Test3{

    public void m3(){
        Test2 t2 = new Test2();
        try {
            t2.m2();
        }catch (ArrayIndexOutOfBoundsException e1){
            System.out.println("first catch block");
            System.out.println(e1.getMessage());
        }catch (NumberFormatException e2){
            System.out.println("second catch block");
            System.out.println(e2.getMessage());
        }finally {  // 不管发生什么错误最终都必须执行的代码
            System.out.println("very important code");
            //有哪些code very important: scanner.close()
        }
        System.out.println("fortschreiten");
    }
}

/*
  常见Exception:
  1. NullPointerException
    一个对象为空，不能调用方法/属性..
  2. ArrayIndexOutOfBoundsException
    通常是遍历时没有正确设置边界值
  3. ClassCastException
    类型转移方向反了
  4. NumberFormatException
 */

class Test4{

    public void m4(){
        ArrayList<String> l = new ArrayList<>();
        l.add("1");
        l.add("2");
        l.add(null);
        l.get(2).length();
        System.out.println(l.get(5));
    }

    public void m5(){
        Student s = new Student();
        Person p = (Person)s;
        Person pp = new Person();
        Student ss = (Student)pp;

    }
}

class Person{}

class Student extends Person{}